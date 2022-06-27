package com.tta.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tta.app.exceptions.EntityNotFoundException;
import com.tta.app.exceptions.TrainingFinishedException;
import com.tta.app.model.User;
import com.tta.app.model.enums.HitType;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.Spin;
import com.tta.app.model.events.EndTrainingEvent;
import com.tta.app.model.events.HitEvent;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.training.Hit;
import com.tta.app.model.training.Training;
import com.tta.app.model.training.TrainingLevelParams;
import com.tta.app.model.training.TrainingRequest;
import com.tta.app.repository.HitRepository;
import com.tta.app.repository.TrainingLevelParamsRepository;
import com.tta.app.repository.TrainingRepository;
import com.tta.app.repository.UserRepository;
import com.tta.app.service.KieService;
import com.tta.app.service.TrainingService;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {
	
	private final TrainingRepository trainingRepository;
	private final TrainingLevelParamsRepository trainingLevelParamsRepository;
	private final UserRepository userRepository;
	private final HitRepository hitRepository;
	
	private final KieService kieService;
	
	@Autowired
	public TrainingServiceImpl(KieService kieService, TrainingRepository trainingRepository, 
			HitRepository hitRepository, UserRepository userRepository, TrainingLevelParamsRepository trainingLevelParamsRepository) {
		super();
		this.kieService = kieService;
		this.trainingRepository = trainingRepository;
		this.hitRepository = hitRepository;
		this.userRepository = userRepository;
		this.trainingLevelParamsRepository = trainingLevelParamsRepository;
	}

	@Override
	public void simulation(Long trainingId, List<Hit> hits) {
		KieSession kieSession = kieService.getCepKieSession();
		Optional<Training> tr = trainingRepository.findById(trainingId);
		
		if (!tr.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		if (tr.get().getFinished()) {
			throw new TrainingFinishedException();
		}
			
        Thread t = new Thread() {
            @Override
            public void run() {
            	kieSession.insert(tr.get());
        		for (Hit hit: hits) {
        			hit.setTraining(tr.get());
        			hitRepository.save(hit);
        			HitEvent hitEvent = createHitEvent(hit, tr.get());
        			kieSession.insert(hitEvent);
        			try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    	// do nothing
                    }
        		}
                kieSession.insert(new EndTrainingEvent(tr.get().getId()));
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            //do nothing
        }
        kieSession.fireUntilHalt();
	}
	
	private HitEvent createHitEvent(Hit hit, Training training) {
		HitEvent hitEvent = new HitEvent();
		hitEvent.setAngleDelta(hit.getAngle() - training.getExpectedAngle());
		hitEvent.setSpeedDelta(hit.getSpeed() - training.getExpectedSpeed());
		hitEvent.setHitResult(hit.getResult());
		hitEvent.setTimestamp(new Date());
		hitEvent.setTrainingId(training.getId());

		return hitEvent;
	}

	@Override
	public Training initTraining(Long userId, RacketOrientation racketOrientation, HitType hitType, Spin spin) {
		Optional<User> u = userRepository.findById(userId);
		if (!u.isPresent()) {
			throw new EntityNotFoundException("User not found");
		}
		if (u.get().getCurrentRacket() == null) {
			throw new EntityNotFoundException("Racket not found");
		}
		
		Racket r = u.get().getCurrentRacket();
		TrainingRequest tr = new TrainingRequest();
		tr.setRacket(r);
		tr.setUser(u.get());
		
		TrainingLevelParams tlp = new TrainingLevelParams();
		
		Training t = new Training();
		t.setBallType(spin);
		t.setRacketOrientation(racketOrientation);
		t.setType(hitType);
		t.setUser(u.get());
		t.setFinished(false);
		t.setDate(System.currentTimeMillis());
		t.setExpectedAngle(getExpectedAngle());
		t.setExpectedSpeed(getExpectedSpeed());
		t.setHits(new ArrayList<Hit>());
		t.setRacket(r);
		t.setLevel(tlp);
		t.setTrainingRequest(tr);
		
		KieSession kieSession = kieService.getDefaultKieSession();
		kieSession.insert(tlp);
		kieSession.insert(r);
		kieSession.insert(u.get());
		kieSession.insert(t);
		kieSession.insert(tr);
		kieSession.fireAllRules();
		
		List<TrainingLevelParams> tlpList = trainingLevelParamsRepository.findOneByLevel(t.getLevel().getLevel());
		
		if (tlpList.size() == 0) {
			throw new EntityNotFoundException("Training Level Params not found for level: " + t.getLevel().getLevel());
		}
		
		t.setLevel(tlpList.get(0));
		
		trainingRepository.save(t);
		
		return t;
	}
	
	private Double getExpectedAngle() {
		Double mid = Math.random() * (50.00 - 35.00) + 35.00;
		Double dist = Math.random() * 10;
		return Math.random() * 2 * dist + mid - dist;
	}
	
	private Double getExpectedSpeed() {
		Double mid = Math.random() * (6.00 - 1.50) + 1.50;
		Double dist = Math.random() * 3;
		return Math.random() * 2 * dist + mid - dist;
	}

}

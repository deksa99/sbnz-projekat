package com.tta.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tta.app.exceptions.EntityNotFoundException;
import com.tta.app.exceptions.TrainingFinishedException;
import com.tta.app.model.events.EndTrainingEvent;
import com.tta.app.model.events.HitEvent;
import com.tta.app.model.training.Hit;
import com.tta.app.model.training.Training;
import com.tta.app.repository.HitRepository;
import com.tta.app.repository.TrainingRepository;
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
	private final HitRepository hitRepository;
	
	private final KieService kieService;
	
	@Autowired
	public TrainingServiceImpl(KieService kieService, TrainingRepository trainingRepository, HitRepository hitRepository) {
		super();
		this.kieService = kieService;
		this.trainingRepository = trainingRepository;
		this.hitRepository = hitRepository;
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
		// TODO check abs values
		hitEvent.setAngleDelta(hit.getAngle() - training.getExpectedAngle());
		hitEvent.setSpeedDelta(hit.getSpeed() - training.getExpectedSpeed());
		hitEvent.setHitResult(hit.getResult());
		hitEvent.setTimestamp(new Date());
		hitEvent.setTrainingId(training.getId());

		return hitEvent;
	}

}

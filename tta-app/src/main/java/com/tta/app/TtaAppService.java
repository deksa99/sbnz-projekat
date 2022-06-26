package com.tta.app;

import java.util.Date;
import java.util.List;

import com.tta.app.model.User;
import com.tta.app.model.events.EndTrainingEvent;
import com.tta.app.model.events.HitEvent;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.model.training.Training;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TtaAppService {
	private static Logger log = LoggerFactory.getLogger(TtaAppService.class);
	private final KieContainer kieContainer;
	
	@Autowired
	public TtaAppService(KieContainer kieContainer) {
		log.info("Initialising a new session.");
		this.kieContainer = kieContainer;
	}
	
	public User test(User u) {
		KieSession kieSession = kieContainer.newKieSession("default");
		kieSession.insert(u);
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}

	public RacketParams getRecommendation(RacketForm form) {
		RacketParams rp = new RacketParams();
		rp.setFormId(form.getId());
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(form);
		kieSession.insert(rp);
		kieSession.fireAllRules();
		kieSession.dispose();
		return rp;
	}

	public String simulation(List<HitEvent> hits) {
		KieSession kieSession = kieContainer.newKieSession("cepTraining");

        Thread t = new Thread() {
            @Override
            public void run() {
        		Training tr = new Training();
        		// TODO update level
        		//tr.setLevel(TrainingLevel.EASY);
        		kieSession.insert(tr);
        		for (HitEvent hit: hits) {
        			hit.setTimestamp(new Date());
        			hit.setTrainingId(tr.getId());
        			kieSession.insert(hit);
        			try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    	// do nothing
                    }
        		}
                kieSession.insert(new EndTrainingEvent());
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
		return "OK";
	}
}

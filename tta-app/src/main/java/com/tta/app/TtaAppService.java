package com.tta.app;

import com.tta.app.model.User;

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
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(u);
		kieSession.fireAllRules();
		kieSession.dispose();
		return u;
	}
}

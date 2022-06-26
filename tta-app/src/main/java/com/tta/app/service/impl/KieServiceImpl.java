package com.tta.app.service.impl;

import com.tta.app.service.KieService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieServiceImpl implements KieService {
	
	private final KieContainer kieContainer;
	
	@Autowired
	public KieServiceImpl(KieContainer kieContainer) {
		super();
		this.kieContainer = kieContainer;
	}

	@Override
	public KieSession getDefaultKieSession() {
		return kieContainer.newKieSession("default");
	}

	@Override
	public KieSession getCepKieSession() {
		return kieContainer.newKieSession("cepTraining");
	}

}

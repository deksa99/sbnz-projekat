package com.tta.app.service.impl;

import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.service.KieService;
import com.tta.app.service.RacketService;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RacketServiceImpl implements RacketService {
	
	private final KieService kieService;
	
	@Autowired
	public RacketServiceImpl(KieService kieService) {
		super();
		this.kieService = kieService;
	}

	@Override
	public RacketParams getRecommendation(RacketForm form) {
		RacketParams rp = new RacketParams();
		rp.setFormId(form.getId());
		KieSession kieSession = kieService.getDefaultKieSession();
		kieSession.insert(form);
		kieSession.insert(rp);
		kieSession.fireAllRules();
		kieSession.dispose();
		return rp;
	}


}

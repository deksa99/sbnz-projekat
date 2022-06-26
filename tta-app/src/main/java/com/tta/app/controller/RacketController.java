package com.tta.app.controller;

import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.service.RacketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/racket")
public class RacketController {
	
	private final RacketService racketService;
	
	@Autowired
	public RacketController(RacketService racketService) {
		super();
		this.racketService = racketService;
	}

	// TODO change RacketParams to Racket
	@RequestMapping(value = "/recommendation", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RacketParams> getRecommendation(@RequestBody(required = true) RacketForm form) {
		RacketParams rp = racketService.getRecommendation(form);
		return ResponseEntity.ok(rp);
	}
	
	
}

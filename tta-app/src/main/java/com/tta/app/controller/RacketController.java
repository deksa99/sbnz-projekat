package com.tta.app.controller;

import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.service.RacketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/rackets")
public class RacketController {
	
	private final RacketService racketService;
	
	@Autowired
	public RacketController(RacketService racketService) {
		super();
		this.racketService = racketService;
	}

	@PostMapping(value = "/recommendation")
	public ResponseEntity<Racket> getRecommendation(@RequestBody(required = true) RacketForm form) {
		Racket r = racketService.getRecommendation(form);
		return ResponseEntity.ok(r);
	}

	@PostMapping(value = "/history/{userId}")
	public ResponseEntity<Racket> getHistoryRecommendation(@PathVariable(required = true) Long userId) {
		Racket r = racketService.getHistoryRecommendation(userId);
		return ResponseEntity.ok(r);
	}
}

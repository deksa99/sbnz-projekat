package com.tta.app.controller;

import java.util.List;

import com.tta.app.model.racket.Rubber;
import com.tta.app.service.RubberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/rubbers")
public class RubberController {
	
	private final RubberService rubberService;
	
	@Autowired
	public RubberController(RubberService rubberService) {
		super();
		this.rubberService = rubberService;
	}

	@GetMapping
	public ResponseEntity<List<Rubber>> getAllRubbers() {
		return ResponseEntity.ok(rubberService.getAllRubbers());
	}
}

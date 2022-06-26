package com.tta.app.controller;

import java.util.List;

import com.tta.app.model.racket.Blade;
import com.tta.app.service.BladeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blades")
public class BladeController {
	
	private final BladeService bladeService;
	
	public BladeController(BladeService bladeService) {
		super();
		this.bladeService = bladeService;
	}

	@GetMapping
	public ResponseEntity<List<Blade>> getBlades() {
		return ResponseEntity.ok(bladeService.getAllBlades());
	}
}

package com.tta.app.controller;

import java.util.List;

import com.tta.app.model.training.TrainingLevelParams;
import com.tta.app.service.TrainingLevelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "api/training-level")
public class TrainingLevelController {
	
	private final TrainingLevelService trainingLevelService;
	
	@Autowired
	public TrainingLevelController(TrainingLevelService trainingLevelService) {
		super();
		this.trainingLevelService = trainingLevelService;
	}

	@PostMapping
	public ResponseEntity<TrainingLevelParams> addLevel(@RequestBody TrainingLevelParams tlp) {
		return ResponseEntity.ok(trainingLevelService.addLevel(tlp));
	}
	
	@GetMapping
	public ResponseEntity<List<TrainingLevelParams>> getAllLevels() {
		return ResponseEntity.ok(trainingLevelService.getAllParams());
	}
}

package com.tta.app.controller;

import java.util.List;

import com.tta.app.dto.TrainingLevelParamsDTO;
import com.tta.app.model.training.TrainingLevelParams;
import com.tta.app.service.TrainingLevelService;

import org.modelmapper.ModelMapper;
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
	private final ModelMapper mapper;
	
	@Autowired
	public TrainingLevelController(TrainingLevelService trainingLevelService, ModelMapper mapper) {
		super();
		this.trainingLevelService = trainingLevelService;
		this.mapper = mapper;
	}

	@PostMapping
	public ResponseEntity<TrainingLevelParamsDTO> addLevel(@RequestBody TrainingLevelParamsDTO tlp) {
		TrainingLevelParams tlpr = trainingLevelService.addLevel(tlp.getAngleDelta(), tlp.getConsecuctiveMisses(), tlp.getFixTechniqueLimit(),
				tlp.getLevel(), tlp.getName(), tlp.getSpeedDelta());
		return ResponseEntity.ok(mapper.map(tlpr, TrainingLevelParamsDTO.class));
	}
	
	@GetMapping
	public ResponseEntity<List<TrainingLevelParams>> getAllLevels() {
		return ResponseEntity.ok(trainingLevelService.getAllParams());
	}
}

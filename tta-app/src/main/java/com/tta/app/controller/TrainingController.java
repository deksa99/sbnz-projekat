package com.tta.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.tta.app.dto.HitDTO;
import com.tta.app.model.training.Hit;
import com.tta.app.service.TrainingService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/trainings")
public class TrainingController {
	
	private final TrainingService trainingService;
	private final ModelMapper mapper;
	
	public TrainingController(TrainingService trainingService, ModelMapper mapper) {
		super();
		this.trainingService = trainingService;
		this.mapper = mapper;
	}

	@PostMapping(value = "/do-training/{trainingId}")
	public ResponseEntity<Boolean> simulation(@RequestBody(required = true) List<HitDTO> hits, @PathVariable Long trainingId) {
		List<Hit> hitList = hits.stream().map(h -> mapper.map(h, Hit.class)).collect(Collectors.toList());
		trainingService.simulation(trainingId, hitList);
		return ResponseEntity.ok(true);
	}
}

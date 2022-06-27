package com.tta.app.service.impl;

import java.util.List;

import com.tta.app.model.training.TrainingLevelParams;
import com.tta.app.repository.TrainingLevelParamsRepository;
import com.tta.app.service.TrainingLevelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingLevelServiceImpl implements TrainingLevelService {
	
	private final TrainingLevelParamsRepository trainingLevelParamsRepository;
	
	@Autowired
	public TrainingLevelServiceImpl(TrainingLevelParamsRepository trainingLevelParamsRepository) {
		super();
		this.trainingLevelParamsRepository = trainingLevelParamsRepository;
	}

	@Override
	public TrainingLevelParams addLevel(TrainingLevelParams tlp) {
		return trainingLevelParamsRepository.save(tlp);
	}

	@Override
	public List<TrainingLevelParams> getAllParams() {
		return trainingLevelParamsRepository.findAll();
	}

}

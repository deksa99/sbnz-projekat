package com.tta.app.service;

import java.util.List;

import com.tta.app.model.training.TrainingLevelParams;

public interface TrainingLevelService {

	public TrainingLevelParams addLevel(TrainingLevelParams tlp);
	public List<TrainingLevelParams> getAllParams();
}

package com.tta.app.service;

import java.util.List;

import com.tta.app.model.training.Hit;

public interface TrainingService {

	public void simulation(Long trainingId, List<Hit> hits);
}

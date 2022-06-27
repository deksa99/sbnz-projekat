package com.tta.app.service;

import java.util.List;

import com.tta.app.model.enums.HitType;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.Spin;
import com.tta.app.model.training.Hit;
import com.tta.app.model.training.Training;

public interface TrainingService {

	public void simulation(Long trainingId, List<Hit> hits);

	public Training initTraining(Long userId, RacketOrientation racketOrientation, HitType hitType, Spin spin);
}

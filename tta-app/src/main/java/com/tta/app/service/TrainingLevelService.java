package com.tta.app.service;

import java.util.List;

import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.training.TrainingLevelParams;

public interface TrainingLevelService {

	public TrainingLevelParams addLevel(TrainingLevelParams tlp);
	public List<TrainingLevelParams> getAllParams();
	public TrainingLevelParams addLevel(double angleDelta, int consecuctiveMisses, double fixTechniqueLimit, TrainingLevel level,
			String name, double speedDelta);
}

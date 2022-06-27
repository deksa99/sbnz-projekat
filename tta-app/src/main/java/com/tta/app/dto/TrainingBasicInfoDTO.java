package com.tta.app.dto;

import com.tta.app.model.training.TrainingLevelParams;

public class TrainingBasicInfoDTO {
	private Long id;
	private TrainingLevelParams level;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TrainingLevelParams getLevel() {
		return level;
	}
	public void setLevel(TrainingLevelParams level) {
		this.level = level;
	}
	
}

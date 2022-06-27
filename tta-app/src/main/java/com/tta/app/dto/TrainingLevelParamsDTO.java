package com.tta.app.dto;

import com.tta.app.model.enums.TrainingLevel;

public class TrainingLevelParamsDTO {
	private Long id;
	private double fixTechniqueLimit;
	private double angleDelta;
	private double speedDelta;
	private int consecuctiveMisses;
	private String name;
	private TrainingLevel level;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getFixTechniqueLimit() {
		return fixTechniqueLimit;
	}
	public void setFixTechniqueLimit(double fixTechniqueLimit) {
		this.fixTechniqueLimit = fixTechniqueLimit;
	}
	public double getAngleDelta() {
		return angleDelta;
	}
	public void setAngleDelta(double angleDelta) {
		this.angleDelta = angleDelta;
	}
	public double getSpeedDelta() {
		return speedDelta;
	}
	public void setSpeedDelta(double speedDelta) {
		this.speedDelta = speedDelta;
	}
	public int getConsecuctiveMisses() {
		return consecuctiveMisses;
	}
	public void setConsecuctiveMisses(int consecuctiveMisses) {
		this.consecuctiveMisses = consecuctiveMisses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TrainingLevel getLevel() {
		return level;
	}
	public void setLevel(TrainingLevel level) {
		this.level = level;
	}
	
	
}

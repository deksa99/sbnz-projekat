package com.tta.app.model.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tta.app.model.enums.TrainingLevel;

@Entity
public class TrainingLevelParams {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private double fixTechniqueLimit;
	@Column(nullable = false)
	private double angleDelta;
	@Column(nullable = false)
	private double speedDelta;
	@Column(nullable = false)
	private int consecuctiveMisses;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private TrainingLevel level;
	
	public TrainingLevelParams() {
		super();
	}

	public TrainingLevelParams(double fixTechniqueLimit, double angleDelta, double speedDelta, int consecuctiveMisses,
			String name, TrainingLevel level) {
		super();
		this.fixTechniqueLimit = fixTechniqueLimit;
		this.angleDelta = angleDelta;
		this.speedDelta = speedDelta;
		this.consecuctiveMisses = consecuctiveMisses;
		this.name = name;
		this.level = level;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getConsecuctiveMisses() {
		return consecuctiveMisses;
	}

	public void setConsecuctiveMisses(int consecuctiveMisses) {
		this.consecuctiveMisses = consecuctiveMisses;
	}
	
}

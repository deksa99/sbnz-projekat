package com.tta.app.model;

public class TrainingLevelTemplate {

	// [0, 1]
	private double fixTechniqueLimit;
	private boolean tooMuchMisses = true;
	private double angleDelta;
	private double speedDelta;
	
	public TrainingLevelTemplate() {
		super();
	}

	public TrainingLevelTemplate(double fixTechniqueLimit, boolean tooMuchMisses, double angleDelta,
			double speedDelta) {
		super();
		this.fixTechniqueLimit = fixTechniqueLimit;
		this.tooMuchMisses = tooMuchMisses;
		this.angleDelta = angleDelta;
		this.speedDelta = speedDelta;
	}

	public double getFixTechniqueLimit() {
		return fixTechniqueLimit;
	}

	public void setFixTechniqueLimit(double fixTechniqueLimit) {
		this.fixTechniqueLimit = fixTechniqueLimit;
	}

	public boolean isTooMuchMisses() {
		return tooMuchMisses;
	}

	public void setTooMuchMisses(boolean tooMuchMisses) {
		this.tooMuchMisses = tooMuchMisses;
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
	
}

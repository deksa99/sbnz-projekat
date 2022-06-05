package com.tta.app.model.racket;

import java.util.List;
import java.util.UUID;

import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;
import com.tta.app.model.enums.TrainingExperience;

public class RacketForm {

	private UUID id;
	private TrainingExperience trainingExperience;
	private List<Situation> situations;
	private Budget budget;
	private Grip grip;
	private GripType gripType;
	
	public RacketForm() {
		super();
		this.id = UUID.randomUUID();
	}
	
	public TrainingExperience getTrainingExperience() {
		return trainingExperience;
	}
	public void setTrainingExperience(TrainingExperience trainingExperience) {
		this.trainingExperience = trainingExperience;
	}
	public List<Situation> getSituations() {
		return situations;
	}
	public void setSituations(List<Situation> situations) {
		this.situations = situations;
	}
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public Grip getGrip() {
		return grip;
	}
	public void setGrip(Grip grip) {
		this.grip = grip;
	}
	public GripType getGripType() {
		return gripType;
	}
	public void setGripType(GripType gripType) {
		this.gripType = gripType;
	}
	public UUID getId() {
		return id;	
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
}

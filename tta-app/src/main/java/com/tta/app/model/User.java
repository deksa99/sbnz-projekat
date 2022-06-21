package com.tta.app.model;

import java.util.List;
import java.util.UUID;

import com.tta.app.model.enums.HealthCondition;
import com.tta.app.model.enums.Playstyle;
import com.tta.app.model.enums.TrainingExperience;
import com.tta.app.model.enums.UserSkill;
import com.tta.app.model.training.Training;

public class User {
	
	private UUID id;
	private String email;
	private String password;
	private TrainingExperience experience;
	private Playstyle playstyle;
	private HealthCondition healthCondition;
	private UserSkill userSkill;
	private List<Training> trainHistory;
	private Double budget;
	
	public User() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TrainingExperience getExperience() {
		return experience;
	}

	public void setExperience(TrainingExperience experience) {
		this.experience = experience;
	}

	public Playstyle getPlaystyle() {
		return playstyle;
	}

	public void setPlaystyle(Playstyle playstyle) {
		this.playstyle = playstyle;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public HealthCondition getHealthCondition() {
		return healthCondition;
		
	}

	public void setHealthCondition(HealthCondition healthCondition) {
		this.healthCondition = healthCondition;
		
	}

	public UUID getId() {
		return id;
		
	}

	public void setId(UUID id) {
		this.id = id;
		
	}

	public UserSkill getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(UserSkill userSkill) {
		this.userSkill = userSkill;
	}

	public List<Training> getTrainHistory() {
		return trainHistory;
	}

	public void setTrainHistory(List<Training> trainHistory) {
		this.trainHistory = trainHistory;
	}
	
	

}

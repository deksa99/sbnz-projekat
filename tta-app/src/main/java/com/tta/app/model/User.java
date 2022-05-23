package com.tta.app.model;

import com.tta.app.model.enums.Playstyle;

public class User {
	
	private String email;
	private String password;
	private String experience;
	private Playstyle playstyle;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
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
	
	

}

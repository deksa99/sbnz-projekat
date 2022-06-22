package com.tta.app.model.racket;

import com.tta.app.model.User;
import com.tta.app.model.enums.RacketRecommendation;

public class NewRacketRecommendation {
	
	private User user;
	private Boolean highAccuracy = null;
	private Boolean highDiversity = null;
	private RacketRecommendation recommendation;
	
	public NewRacketRecommendation() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RacketRecommendation getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(RacketRecommendation recommendation) {
		this.recommendation = recommendation;
	}

	public Boolean getHighAccuracy() {
		return highAccuracy;
	}

	public void setHighAccuracy(Boolean highAccuracy) {
		this.highAccuracy = highAccuracy;
	}

	public Boolean getHighDiversity() {
		return highDiversity;
	}

	public void setHighDiversity(Boolean highDiversity) {
		this.highDiversity = highDiversity;
	}
	
}

package com.tta.app.model.training;

import java.util.List;

import com.tta.app.model.racket.Racket;

public class TrainingRequest {

	private Long userId;
	private Racket racket;
	private List<Training> trainHistory;
	
	public TrainingRequest() {
		super();
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Racket getRacket() {
		return racket;
	}
	public void setRacket(Racket racket) {
		this.racket = racket;
	}
	public List<Training> getTrainHistory() {
		return trainHistory;
	}
	public void setTrainHistory(List<Training> trainHistory) {
		this.trainHistory = trainHistory;
	}
	
	
}

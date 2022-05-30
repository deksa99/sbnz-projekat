package com.tta.app.model.racket;

import java.util.List;

import com.tta.app.model.training.Training;

public class History {
	
	private List<Training> trainHistory;
	
	public History() {
		super();
	}

	public List<Training> getTrainHistory() {
		return trainHistory;
	}

	public void setTrainHistory(List<Training> trainHistory) {
		this.trainHistory = trainHistory;
	}
	
}

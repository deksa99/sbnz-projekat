package com.tta.app.model.training;

import com.tta.app.model.User;
import com.tta.app.model.racket.Racket;

public class TrainingRequest {

	private User user;
	private Racket racket;
	
	public TrainingRequest() {
		super();
	}
	
	public Racket getRacket() {
		return racket;
	}
	public void setRacket(Racket racket) {
		this.racket = racket;
	}

	public User getUser() {
		return user;
		
	}

	public void setUser(User user) {
		this.user = user;
		
	}
	
	
}

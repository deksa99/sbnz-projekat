package com.tta.app.model.training;

import java.util.UUID;

import com.tta.app.model.User;
import com.tta.app.model.racket.Racket;

public class TrainingRequest {

	private UUID id;
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

	public UUID getId() {
		return id;
		
	}

	public void setId(UUID id) {
		this.id = id;
		
	}
	
	
}

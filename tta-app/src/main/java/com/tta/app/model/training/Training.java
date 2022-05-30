package com.tta.app.model.training;

import java.util.List;

import com.tta.app.model.User;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.enums.TrainingType;
import com.tta.app.model.racket.Racket;

public class Training {
	
	private RacketOrientation racketOrientation;
	private TrainingType type;
	private TrainingLevel level;
	
	private String ballType;
	private Double expectedAngle;
	private Double expectedSpeed;
	
	private User user;
	private Racket racket;
	private List<Hit> hits;
	
	public Training() {
		super();
	}

	public RacketOrientation getRacketOrientation() {
		return racketOrientation;
	}

	public void setRacketOrientation(RacketOrientation racketOrientation) {
		this.racketOrientation = racketOrientation;
	}

	public TrainingType getType() {
		return type;
	}

	public void setType(TrainingType type) {
		this.type = type;
	}

	public TrainingLevel getLevel() {
		return level;
	}

	public void setLevel(TrainingLevel level) {
		this.level = level;
	}

	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public Double getExpectedAngle() {
		return expectedAngle;
	}

	public void setExpectedAngle(Double expectedAngle) {
		this.expectedAngle = expectedAngle;
	}

	public Double getExpectedSpeed() {
		return expectedSpeed;
	}

	public void setExpectedSpeed(Double expectedSpeed) {
		this.expectedSpeed = expectedSpeed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Racket getRacket() {
		return racket;
	}

	public void setRacket(Racket racket) {
		this.racket = racket;
	}

	public List<Hit> getHits() {
		return hits;
	}

	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}
	
	
}

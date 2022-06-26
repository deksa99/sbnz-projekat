package com.tta.app.model.training;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tta.app.model.User;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.Spin;
import com.tta.app.model.enums.HitType;
import com.tta.app.model.racket.Racket;

@Entity
@Table(name = "training")
public class Training {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private RacketOrientation racketOrientation;
	@Enumerated(EnumType.STRING)
	private HitType type;

	private Long date;
	
	@ManyToOne
	private TrainingLevelParams level;
	
	private Spin spin;
	private Double expectedAngle;
	private Double expectedSpeed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@Transient
	private TrainingRequest trainingRequest;
	@ManyToOne(fetch = FetchType.LAZY)
	private Racket racket;
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "training")
	private List<Hit> hits;
	
	private Boolean successful = null;
	private Boolean finished = false;
	
	public Training() {
		super();
	}

	public Training(RacketOrientation racketOrientation, HitType type, TrainingLevelParams level, Long date,
			Spin spin, Double expectedAngle, Double expectedSpeed, User user,
			Racket racket, List<Hit> hits, Boolean successful, Boolean finished) {
		super();
		this.racketOrientation = racketOrientation;
		this.type = type;
		this.level = level;
		this.date = date;
		this.spin = spin;
		this.expectedAngle = expectedAngle;
		this.expectedSpeed = expectedSpeed;
		this.user = user;
		this.racket = racket;
		this.hits = hits;
		this.successful = successful;
		this.finished = finished;
	}



	public RacketOrientation getRacketOrientation() {
		return racketOrientation;
	}

	public void setRacketOrientation(RacketOrientation racketOrientation) {
		this.racketOrientation = racketOrientation;
	}

	public HitType getType() {
		return type;
	}

	public void setType(HitType type) {
		this.type = type;
	}

	public TrainingLevelParams getLevel() {
		return level;
	}

	public void setLevel(TrainingLevelParams level) {
		this.level = level;
	}

	public Spin getBallType() {
		return spin;
	}

	public void setBallType(Spin spin) {
		this.spin = spin;
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

	public Long getId() {
		return id;
		
	}

	public void setId(Long id) {
		this.id = id;
		
	}

	public Boolean getSuccessful() {
		return successful;
		
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
		
	}

	public Long getDate() {
		return date;
		
	}

	public void setDate(Long date) {
		this.date = date;
		
	}

	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
		
	}

	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
		
	}

	public Boolean getFinished() {
		return finished;
		
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
		
	}

	public Spin getSpin() {
		return spin;
	}

	public void setSpin(Spin spin) {
		this.spin = spin;
	}
	
}

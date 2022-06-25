package com.tta.app.model.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tta.app.model.enums.HitResult;

@Entity
@Table(name = "hit")
public class Hit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double angle;
	@Column(nullable = false)
	private Double speed;
	private Double startPosition;
	private Double endPosition;
	@ManyToOne(fetch = FetchType.LAZY)
	private Training training;
	@Enumerated(EnumType.STRING)
	private HitResult result;
	
	public Hit() {
		super();
	}
	

	public Hit(Double angle, Double speed, Training training, HitResult result) {
		super();
		this.angle = angle;
		this.speed = speed;
		this.training = training;
		this.result = result;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Double startPosition) {
		this.startPosition = startPosition;
	}

	public Double getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Double endPosition) {
		this.endPosition = endPosition;
	}

	public HitResult getResult() {
		return result;
	}

	public void setResult(HitResult result) {
		this.result = result;
	}

	public Training getTraining() {
		return training;
		
	}

	public void setTraining(Training training) {
		this.training = training;
		
	}
	
	
}

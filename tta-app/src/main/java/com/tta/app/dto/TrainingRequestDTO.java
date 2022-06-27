package com.tta.app.dto;

import com.tta.app.model.enums.HitType;
import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.Spin;

public class TrainingRequestDTO {
	
	private Long userId;
	private HitType hitType;
	private RacketOrientation racketOrientation;
	private Spin spin;
	
	public TrainingRequestDTO() {
		super();
	}

	public TrainingRequestDTO(Long userId, HitType hitType, RacketOrientation racketOrientation, Spin spin) {
		super();
		this.userId = userId;
		this.hitType = hitType;
		this.racketOrientation = racketOrientation;
		this.spin = spin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public HitType getHitType() {
		return hitType;
	}

	public void setHitType(HitType hitType) {
		this.hitType = hitType;
	}

	public RacketOrientation getRacketOrientation() {
		return racketOrientation;
	}

	public void setRacketOrientation(RacketOrientation racketOrientation) {
		this.racketOrientation = racketOrientation;
	}

	public Spin getSpin() {
		return spin;
	}

	public void setSpin(Spin spin) {
		this.spin = spin;
	}
	
}

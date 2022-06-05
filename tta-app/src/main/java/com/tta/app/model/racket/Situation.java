package com.tta.app.model.racket;

import com.tta.app.model.enums.RacketOrientation;
import com.tta.app.model.enums.HitType;

public class Situation {

	private RacketOrientation racketOrientation;
	private HitType response;
	private Double coef;
	
	public Situation() {
		super();
	}
	
	public RacketOrientation getRacketOrientation() {
		return racketOrientation;
	}
	public void setRacketOrientation(RacketOrientation racketOrientation) {
		this.racketOrientation = racketOrientation;
	}
	public HitType getResponse() {
		return response;
	}
	public void setResponse(HitType response) {
		this.response = response;
	}
	public Double getCoef() {
		return coef;
	}
	public void setCoef(Double coef) {
		this.coef = coef;
	}
}

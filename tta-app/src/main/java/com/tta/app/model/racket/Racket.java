package com.tta.app.model.racket;

import com.tta.app.model.enums.RacketLevel;

public class Racket {
	
	private Blade blade;
	private Rubber fhRubber;
	private Rubber bhRubber;
	private Double speed;
	private Double spin;
	private Double control;
	private RacketLevel racketLevel;

	public Racket() {
		super();
	}

	public Blade getBlade() {
		return blade;
	}

	public void setBlade(Blade blade) {
		this.blade = blade;
	}

	public Rubber getFhRubber() {
		return fhRubber;
	}

	public void setFhRubber(Rubber fhRubber) {
		this.fhRubber = fhRubber;
	}

	public Rubber getBhRubber() {
		return bhRubber;
	}

	public void setBhRubber(Rubber bhRubber) {
		this.bhRubber = bhRubber;
	}

	public RacketLevel getRacketLevel() {
		return racketLevel;
		
	}

	public void setRacketLevel(RacketLevel racketLevel) {
		this.racketLevel = racketLevel;
		
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getSpin() {
		return spin;
	}

	public void setSpin(Double spin) {
		this.spin = spin;
	}

	public Double getControl() {
		return control;
	}

	public void setControl(Double control) {
		this.control = control;
	}
	
}

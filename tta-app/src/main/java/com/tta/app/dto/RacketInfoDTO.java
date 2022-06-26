package com.tta.app.dto;

import com.tta.app.model.enums.RacketLevel;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.Rubber;

public class RacketInfoDTO {
	private Long id;
	private Blade blade;
	private Rubber fhRubber;
	private Rubber bhRubber;
	private Double speed;
	private Double spin;
	private Double control;
	private RacketLevel racketLevel;
	
	public RacketInfoDTO() {
		super();
	}

	public RacketInfoDTO(Long id, Blade blade, Rubber fhRubber, Rubber bhRubber, Double speed, Double spin,
			Double control, RacketLevel racketLevel) {
		super();
		this.id = id;
		this.blade = blade;
		this.fhRubber = fhRubber;
		this.bhRubber = bhRubber;
		this.speed = speed;
		this.spin = spin;
		this.control = control;
		this.racketLevel = racketLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public RacketLevel getRacketLevel() {
		return racketLevel;
	}

	public void setRacketLevel(RacketLevel racketLevel) {
		this.racketLevel = racketLevel;
	}
	
	
}

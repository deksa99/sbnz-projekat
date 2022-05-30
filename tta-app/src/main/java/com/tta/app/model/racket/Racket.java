package com.tta.app.model.racket;

public class Racket {
	
	private Blade blade;
	private Rubber fhRubber;
	private Rubber bhRubber;

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
	
	
}

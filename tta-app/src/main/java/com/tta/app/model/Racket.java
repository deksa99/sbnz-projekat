package com.tta.app.model;

public class Racket {
	
	private Blade wood;
	private Rubber fhTire;
	private Rubber bhTire;

	public Racket() {
		super();
	}

	public Blade getWood() {
		return wood;
	}

	public void setWood(Blade wood) {
		this.wood = wood;
	}

	public Rubber getFhTire() {
		return fhTire;
	}

	public void setFhTire(Rubber fhTire) {
		this.fhTire = fhTire;
	}

	public Rubber getBhTire() {
		return bhTire;
	}

	public void setBhTire(Rubber bhTire) {
		this.bhTire = bhTire;
	}
	
	
}

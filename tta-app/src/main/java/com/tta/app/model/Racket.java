package com.tta.app.model;

public class Racket {
	
	private Wood wood;
	private Tire fhTire;
	private Tire bhTire;

	public Racket() {
		super();
	}

	public Wood getWood() {
		return wood;
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	public Tire getFhTire() {
		return fhTire;
	}

	public void setFhTire(Tire fhTire) {
		this.fhTire = fhTire;
	}

	public Tire getBhTire() {
		return bhTire;
	}

	public void setBhTire(Tire bhTire) {
		this.bhTire = bhTire;
	}
	
	
}

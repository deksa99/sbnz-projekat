package com.tta.app.model.racket;

import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;

public class Blade {

	private Double speed;
	private Double control;
	private Double stiffness;
	private Double hardness;
	private Double consistency;
	private Double weight;
	private Double price;
	private Grip grip;
	private GripType gripType;
	
	public Blade() {
		super();
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getControl() {
		return control;
	}

	public void setControl(Double control) {
		this.control = control;
	}

	public Double getStiffness() {
		return stiffness;
	}

	public void setStiffness(Double stiffness) {
		this.stiffness = stiffness;
	}

	public Double getHardness() {
		return hardness;
	}

	public void setHardness(Double hardness) {
		this.hardness = hardness;
	}

	public Double getConsistency() {
		return consistency;
	}

	public void setConsistency(Double consistency) {
		this.consistency = consistency;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Grip getGrip() {
		return grip;
	}

	public void setGrip(Grip grip) {
		this.grip = grip;
	}

	public GripType getGripType() {
		return gripType;
	}

	public void setGripType(GripType gripType) {
		this.gripType = gripType;
	}
	
}

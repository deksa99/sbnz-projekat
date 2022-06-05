package com.tta.app.model.racket;

import java.util.UUID;

import com.tta.app.model.common.Range;
import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;

public class RacketParams {
	
	private UUID formId;
	private Range bladePrice;
	private Range rubberPrice;
	private Range controlRange;
	private Integer stylePoints;
	private Grip grip;
	private GripType gripType;
	
	public RacketParams() {
		super();
		this.bladePrice = new Range();
		this.rubberPrice = new Range();
		this.controlRange = new Range();
	}

	public Integer getStylePoints() {
		return stylePoints;
	}
	public void setStylePoints(Integer stylePoints) {
		this.stylePoints = stylePoints;
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
	public Range getControlRange() {
		return controlRange;
		
	}
	public void setControlRange(Range controlRange) {
		this.controlRange = controlRange;
		
	}
	public Range getBladePrice() {
		return bladePrice;
	}

	public void setBladePrice(Range bladePrice) {
		this.bladePrice = bladePrice;
	}

	public Range getRubberPrice() {
		return rubberPrice;
	}

	public void setRubberPrice(Range rubberPrice) {
		this.rubberPrice = rubberPrice;
	}

	public UUID getFormId() {
		return formId;
		
	}
	public void setFormId(UUID formId) {
		this.formId = formId;	
	}
	
}

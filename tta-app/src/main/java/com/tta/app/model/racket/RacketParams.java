package com.tta.app.model.racket;

import com.tta.app.model.common.Range;
import com.tta.app.model.enums.Grip;
import com.tta.app.model.enums.GripType;

public class RacketParams {
	
	private Double minControl;
	private Double minBladePrice;
	private Double minRubberPrice;
	private Double maxBladePrice;
	private Double maxRubberPrice;
	private Integer stylePoints;
	private Range controlRange;
	private Grip grip;
	private GripType gripType;
	
	public RacketParams() {
		super();
	}
	public Double getMinControl() {
		return minControl;
	}
	public void setMinControl(Double minControl) {
		this.minControl = minControl;
	}
	public Double getMaxBladePrice() {
		return maxBladePrice;
	}
	public void setMaxBladePrice(Double maxBladePrice) {
		this.maxBladePrice = maxBladePrice;
	}
	public Double getMaxRubberPrice() {
		return maxRubberPrice;
	}
	public void setMaxRubberPrice(Double maxRubberPrice) {
		this.maxRubberPrice = maxRubberPrice;
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
	public Double getMinBladePrice() {
		return minBladePrice;
		
	}
	public void setMinBladePrice(Double minBladePrice) {
		this.minBladePrice = minBladePrice;
		
	}
	public Double getMinRubberPrice() {
		return minRubberPrice;
		
	}
	public void setMinRubberPrice(Double minRubberPrice) {
		this.minRubberPrice = minRubberPrice;
		
	}
	public Range getControlRange() {
		return controlRange;
		
	}
	public void setControlRange(Range controlRange) {
		this.controlRange = controlRange;
		
	}
	
	
}

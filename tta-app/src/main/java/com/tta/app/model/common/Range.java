package com.tta.app.model.common;

public class Range {
	
	private Double min = 0.0;
	private Double max = Double.MAX_VALUE;
	
	public Range() {
		super();
	}
	
	public Range(Double min, Double max) {
		super();
		this.min = min == null ? 0.0 : min;
		this.max = max == null ? Double.MAX_VALUE : max;
	}
	
	
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	
}

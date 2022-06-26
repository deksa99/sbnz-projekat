package com.tta.app.dto;

import com.tta.app.model.enums.HitResult;

public class HitDTO {
	private Long angle;
	private Long speed;
	private HitResult result;
	
	public HitDTO() {
		super();
	}

	public HitDTO(Long angle, Long speed, HitResult result) {
		super();
		this.angle = angle;
		this.speed = speed;
		this.result = result;
	}

	public Long getAngle() {
		return angle;
	}

	public void setAngle(Long angle) {
		this.angle = angle;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public HitResult getResult() {
		return result;
	}

	public void setResult(HitResult hitResult) {
		this.result = hitResult;
	}
	
}

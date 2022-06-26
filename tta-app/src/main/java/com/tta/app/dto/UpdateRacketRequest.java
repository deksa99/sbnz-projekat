package com.tta.app.dto;

public class UpdateRacketRequest {
	
	private Long userId;
	private Long bladeId;
	private Long fhRubberId;
	private Long bhRubberId;
	
	public UpdateRacketRequest() {
		super();
	}
	
	public UpdateRacketRequest(Long userId, Long bladeId, Long fhRubberId, Long bhRubberId) {
		super();
		this.userId = userId;
		this.bladeId = bladeId;
		this.fhRubberId = fhRubberId;
		this.bhRubberId = bhRubberId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBladeId() {
		return bladeId;
	}
	public void setBladeId(Long bladeId) {
		this.bladeId = bladeId;
	}
	public Long getFhRubberId() {
		return fhRubberId;
	}
	public void setFhRubberId(Long fhRubberId) {
		this.fhRubberId = fhRubberId;
	}
	public Long getBhRubberId() {
		return bhRubberId;
	}
	public void setBhRubberId(Long bhRubberId) {
		this.bhRubberId = bhRubberId;
	}
	
}

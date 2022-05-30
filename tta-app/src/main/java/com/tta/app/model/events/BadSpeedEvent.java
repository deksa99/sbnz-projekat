package com.tta.app.model.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.PropertyReactive;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
@PropertyReactive
@Timestamp("timestamp")
public class BadSpeedEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private Boolean processed = false;
	private Long trainingId;
	
	
	public BadSpeedEvent(Long trainingId) {
		super();
		this.trainingId = trainingId;
		this.timestamp = new Date();
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getProcessed() {
		return processed;
	}
	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}
	
}

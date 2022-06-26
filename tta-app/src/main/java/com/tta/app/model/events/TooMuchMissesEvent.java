package com.tta.app.model.events;

import java.io.Serializable;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
public class TooMuchMissesEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private boolean processed = false;
	private Long trainingId;
	
	public TooMuchMissesEvent(Long trainingId) {
		super();
		this.trainingId = trainingId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

	public boolean isProcessed() {
		return processed;
		
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
		
	}
}

package com.tta.app.model.events;

import java.io.Serializable;
import java.util.UUID;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
public class TooMuchMissesEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private UUID trainingId;
	
	public TooMuchMissesEvent(UUID trainingId) {
		super();
		this.trainingId = trainingId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UUID getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(UUID trainingId) {
		this.trainingId = trainingId;
	}
}

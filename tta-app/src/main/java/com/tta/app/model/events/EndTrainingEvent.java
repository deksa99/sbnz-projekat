package com.tta.app.model.events;

import java.io.Serializable;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
public class EndTrainingEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Boolean processed = false;

	public EndTrainingEvent() {
		super();
	}

	public EndTrainingEvent(Boolean processed) {
		super();
		this.processed = processed;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}
}

package com.tta.app.model.events;

import java.util.Date;
import java.util.UUID;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class MissEvent {

	private Boolean processed = false;
	private Date timestamp;
	private UUID trainingId;
    
    public MissEvent(UUID trainingId) {
        this.processed = false;
        this.timestamp = new Date();
        this.trainingId = trainingId;
    }

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public UUID getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(UUID trainingId) {
		this.trainingId = trainingId;
	}
    
}

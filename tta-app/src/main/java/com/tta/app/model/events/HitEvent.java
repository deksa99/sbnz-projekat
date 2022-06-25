package com.tta.app.model.events;

import java.io.Serializable;
import java.util.Date;

import com.tta.app.model.enums.HitResult;

import org.kie.api.definition.type.PropertyReactive;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Role.Type;
import org.kie.api.definition.type.Timestamp;

@Role(Type.EVENT)
@Timestamp("timestamp")
@PropertyReactive
public class HitEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private double angleDelta;
	private double speedDelta;
	private HitResult hitResult;
	private Long trainingId;
	
	// Pomocni atributi
	private boolean badAngleProcessed = false;
	private boolean badSpeedProcessed = false;
	private boolean missProcessed = false;
	
	public HitEvent() {
		super();
		this.timestamp = new Date();
	}
	
	public HitEvent(Date timestamp, double angleDelta, double speedDelta, HitResult hitResult, Long trainingId) {
		super();
		this.timestamp = timestamp;
		this.angleDelta = angleDelta;
		this.speedDelta = speedDelta;
		this.hitResult = hitResult;
		this.trainingId = trainingId;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getAngleDelta() {
		return angleDelta;
	}
	public void setAngleDelta(double angleDelta) {
		this.angleDelta = angleDelta;
	}
	public double getSpeedDelta() {
		return speedDelta;
	}
	public void setSpeedDelta(double speedDelta) {
		this.speedDelta = speedDelta;
	}
	public HitResult getHitResult() {
		return hitResult;
	}
	public void setHitResult(HitResult hitResult) {
		this.hitResult = hitResult;
	}
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

	public boolean isBadAngleProcessed() {
		return badAngleProcessed;
	}
	public void setBadAngleProcessed(boolean badAngleProcessed) {
		this.badAngleProcessed = badAngleProcessed;
	}
	public boolean isBadSpeedProcessed() {
		return badSpeedProcessed;
	}
	public void setBadSpeedProcessed(boolean badSpeedProcessed) {
		this.badSpeedProcessed = badSpeedProcessed;
	}

	public boolean isMissProcessed() {
		return missProcessed;
		
	}

	public void setMissProcessed(boolean missProcessed) {
		this.missProcessed = missProcessed;
		
	}
	
}

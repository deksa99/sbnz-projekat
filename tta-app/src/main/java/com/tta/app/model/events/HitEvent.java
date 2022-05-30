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
	private double speedDeta;
	private HitResult hitResult;
	private Long trainingId;
	
	public HitEvent() {
		super();
	}
	
	public HitEvent(Date timestamp, double angleDelta, double speedDeta, HitResult hitResult, Long trainingId) {
		super();
		this.timestamp = timestamp;
		this.angleDelta = angleDelta;
		this.speedDeta = speedDeta;
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
	public double getSpeedDeta() {
		return speedDeta;
	}
	public void setSpeedDeta(double speedDeta) {
		this.speedDeta = speedDeta;
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
	
}

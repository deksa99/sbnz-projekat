package com.tta.app.exceptions;

import org.springframework.http.HttpStatus;

public class TrainingFinishedException extends HandleableException {
	
	private static final long serialVersionUID = 1L;

	public TrainingFinishedException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public TrainingFinishedException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public TrainingFinishedException(String message, Object payload) {
        super(message, payload, HttpStatus.BAD_REQUEST);
    }
    
}

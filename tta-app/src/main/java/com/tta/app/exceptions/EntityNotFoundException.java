package com.tta.app.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends HandleableException {
	
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public EntityNotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public EntityNotFoundException(String message, Object payload) {
        super(message, payload, HttpStatus.BAD_REQUEST);
    }
    
}

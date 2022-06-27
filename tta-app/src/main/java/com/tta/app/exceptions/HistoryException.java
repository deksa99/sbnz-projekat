package com.tta.app.exceptions;

import org.springframework.http.HttpStatus;

public class HistoryException extends HandleableException {
	
	private static final long serialVersionUID = 1L;

	public HistoryException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public HistoryException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public HistoryException(String message, Object payload) {
        super(message, payload, HttpStatus.BAD_REQUEST);
    }
}

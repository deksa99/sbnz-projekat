package com.tta.app.dto;

public class AuthResponse {
	
	private String jwt;

	public AuthResponse() {
		super();
	}

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}

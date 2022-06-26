package com.tta.app.dto;

public class AuthResponse {
	
	private UserInfoDTO user;
	private String jwt;

	public AuthResponse() {
		super();
	}

	public AuthResponse(UserInfoDTO user, String jwt) {
		super();
		this.user = user;
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public UserInfoDTO getUser() {
		return user;
		
	}

	public void setUser(UserInfoDTO user) {
		this.user = user;
		
	}
	
}

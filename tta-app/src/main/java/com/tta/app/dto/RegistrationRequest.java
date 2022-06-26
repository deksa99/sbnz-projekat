package com.tta.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistrationRequest {
	@NotBlank(message = "First name can not be blank")
	private String firstName;
	@NotBlank(message = "Last name can not be blank")
	private String lastName;
	@NotBlank(message = "Email can not be blank")
	private String email;
	@NotBlank(message = "Password can not be blank")
	@Size(min = 8, max = 128, message = "Password must be 8-128 characters")
	private String password;
	
	public RegistrationRequest() {
		super();
	}
	
	public RegistrationRequest(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

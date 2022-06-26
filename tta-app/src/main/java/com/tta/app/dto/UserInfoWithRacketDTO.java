package com.tta.app.dto;

public class UserInfoWithRacketDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private RacketInfoDTO racket;
	
	public UserInfoWithRacketDTO() {
		super();
	}
	
	public UserInfoWithRacketDTO(Long id, String firstName, String lastName, String email, String password,
			RacketInfoDTO racket) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.racket = racket;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public RacketInfoDTO getRacket() {
		return racket;
	}
	public void setRacket(RacketInfoDTO racket) {
		this.racket = racket;
	}
	
}

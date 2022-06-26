package com.tta.app.service;

import com.tta.app.model.User;

public interface UserService {
	
	public User findByEmail(String email);
	
	public User registraion(String email, String password, String firstName, String lastName);

	public User updateRacket(Long userId, Long bladeId, Long fhRubberId, Long bhRubberId);
	
}

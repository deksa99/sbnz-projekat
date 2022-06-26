package com.tta.app.service;

import com.tta.app.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	public User findByEmail(String email);
	
}

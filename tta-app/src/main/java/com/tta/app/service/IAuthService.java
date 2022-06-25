package com.tta.app.service;

import com.tta.app.model.User;

public interface IAuthService {
	public User findByEmail(String email);
}

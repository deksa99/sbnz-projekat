package com.tta.app.service;

import com.tta.app.dto.AuthResponse;

public interface AuthService {

	public AuthResponse authenticate(String username, String password);
}

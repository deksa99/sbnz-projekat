package com.tta.app.controller;

import com.tta.app.dto.AuthRequest;
import com.tta.app.dto.AuthResponse;
import com.tta.app.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
		AuthResponse authenticatedUser = authService.authenticate(authRequest.getUsername(),
				authRequest.getPassword());

        return ResponseEntity.ok(authenticatedUser);
	}
}

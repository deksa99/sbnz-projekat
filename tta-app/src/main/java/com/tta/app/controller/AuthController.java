package com.tta.app.controller;

import com.tta.app.dto.AuthRequest;
import com.tta.app.dto.AuthResponse;
import com.tta.app.dto.UserInfoDTO;
import com.tta.app.model.User;
import com.tta.app.service.AuthService;
import com.tta.app.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
	
	private final AuthService authService;
	private final UserService userService;
	
	private final ModelMapper mapper;
	
	@Autowired
	public AuthController(AuthService authService, UserService userService, ModelMapper mapper) {
		this.authService = authService;
		this.userService = userService;
		this.mapper = mapper;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
		AuthResponse authenticatedUser = authService.authenticate(authRequest.getUsername(),
				authRequest.getPassword());

        return ResponseEntity.ok(authenticatedUser);
	}
	
	@GetMapping(value = "/authority")
    ResponseEntity<UserInfoDTO> getMyAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        User user = (User) authentication.getPrincipal();

        user = userService.findByEmail(user.getEmail());
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        UserInfoDTO userDTO = mapper.map(user, UserInfoDTO.class);

        return ResponseEntity.ok(userDTO);
    }
}

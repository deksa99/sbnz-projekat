package com.tta.app.service.impl;

import com.tta.app.dto.AuthResponse;
import com.tta.app.dto.UserInfoDTO;
import com.tta.app.model.User;
import com.tta.app.security.utils.JwtUtil;
import com.tta.app.service.AuthService;
import com.tta.app.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final AuthenticationManager authenticationManager;
	private final ModelMapper mapper;
	private final JwtUtil jwtUtil;
	
	private final UserService userService;
	
	@Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
    		UserService userService, ModelMapper mapper) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.mapper = mapper;
    }

	
    @Override
    public AuthResponse authenticate(String username, String password) {
        User user = userService.findByEmail(username);

        String jwt = "";
        if(user != null) {
            jwt = generateJwt(username, password, user.getId().toString());
        } else {
            jwt = generateJwt(username, password, null);
        }

        return new AuthResponse(mapper.map(user, UserInfoDTO.class), jwt);
    }

    private String generateJwt(String username, String password, String accountId) {
        Authentication authentication = getAuthentication(username, password);

        return jwtUtil.generateToken(authentication, username, accountId);
    }

    private Authentication getAuthentication(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(usernamePasswordToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }
	
}

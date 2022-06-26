package com.tta.app.controller;

import javax.validation.Valid;

import com.tta.app.dto.RegistrationRequest;
import com.tta.app.dto.UserInfoDTO;
import com.tta.app.model.User;
import com.tta.app.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
	
	private final ModelMapper mapper;
	private final UserService userService;
	
	@Autowired
	public UserController(ModelMapper mapper, UserService userService) {
		super();
		this.mapper = mapper;
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserInfoDTO> addUser(@Valid @RequestBody RegistrationRequest request) {
		User user = userService.registraion(request.getEmail(), request.getPassword(), request.getFirstName(), request.getLastName());
		
		UserInfoDTO info = mapper.map(user, UserInfoDTO.class);
		
		return ResponseEntity.ok(info);
	}
	
}

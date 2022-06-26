package com.tta.app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.tta.app.model.User;
import com.tta.app.model.enums.Role;
import com.tta.app.model.training.Training;
import com.tta.app.repository.UserRepository;
import com.tta.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

	@Override
	public User registraion(String email, String password, String firstName, String lastName) {
		User user = new User(
				email,
				passwordEncoder.encode(password), 
				firstName,
				lastName,
				null, 
				null, 
				null, 
				null, 
				new ArrayList<Training>(),
				null,
				null, 
				Role.PLAYER);
		
		return userRepository.save(user);
	}

}

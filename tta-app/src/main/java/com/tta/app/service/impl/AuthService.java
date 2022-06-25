package com.tta.app.service.impl;

import java.util.Optional;

import com.tta.app.model.User;
import com.tta.app.repository.UserRepository;
import com.tta.app.security.AuthUser;
import com.tta.app.service.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService, UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);

    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if (user == null) {
            return null;
        }
		return new AuthUser(user);
	}
	
}

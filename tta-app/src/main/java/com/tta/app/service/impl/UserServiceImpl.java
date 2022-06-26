package com.tta.app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.tta.app.exceptions.EntityNotFoundException;
import com.tta.app.model.User;
import com.tta.app.model.enums.Role;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.Rubber;
import com.tta.app.model.training.Training;
import com.tta.app.repository.BladeRepository;
import com.tta.app.repository.RacketRepository;
import com.tta.app.repository.RubberRepository;
import com.tta.app.repository.UserRepository;
import com.tta.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final BladeRepository bladeRepository;
	private final RubberRepository rubberRepository;
	private final RacketRepository racketRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, BladeRepository bladeRepository, RacketRepository racketRepository,
			RubberRepository rubberRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bladeRepository = bladeRepository;
		this.rubberRepository = rubberRepository;
		this.racketRepository = racketRepository;
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

	@Override
	public User updateRacket(Long userId, Long bladeId, Long fhRubberId, Long bhRubberId) {
		Optional<User> user = userRepository.findById(userId);
		Optional<Blade> blade = bladeRepository.findById(bladeId);
		Optional<Rubber> fhRubber = rubberRepository.findById(fhRubberId);
		Optional<Rubber> bhRubber = rubberRepository.findById(bhRubberId);
		
		if (!user.isPresent() || !blade.isPresent() || !fhRubber.isPresent() || !bhRubber.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		if (user.get().getRole() != Role.PLAYER) {
			throw new EntityNotFoundException();
		}
		
		Racket r = new Racket(blade.get(), fhRubber.get(), bhRubber.get());
		r = racketRepository.save(r);
		
		user.get().setCurrentRacket(r);
		
		return userRepository.save(user.get());
	}

}

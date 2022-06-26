package com.tta.app.service.impl;

import java.util.List;

import com.tta.app.model.racket.Blade;
import com.tta.app.repository.BladeRepository;
import com.tta.app.service.BladeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BladeServiceImpl implements BladeService {
	
	private final BladeRepository bladeRepository;
	
	@Autowired
	public BladeServiceImpl(BladeRepository bladeRepository) {
		super();
		this.bladeRepository = bladeRepository;
	}

	@Override
	public List<Blade> getAllBlades() {
		return bladeRepository.findAll();
	}

}

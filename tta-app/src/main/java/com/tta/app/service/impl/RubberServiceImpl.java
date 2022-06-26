package com.tta.app.service.impl;

import java.util.List;

import com.tta.app.model.racket.Rubber;
import com.tta.app.repository.RubberRepository;
import com.tta.app.service.RubberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubberServiceImpl implements RubberService {
	
	private final RubberRepository rubberRepository;

	@Autowired
	public RubberServiceImpl(RubberRepository rubberRepository) {
		super();
		this.rubberRepository = rubberRepository;
	}

	@Override
	public List<Rubber> getAllRubbers() {
		return rubberRepository.findAll();
	}

}

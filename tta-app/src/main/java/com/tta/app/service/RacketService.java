package com.tta.app.service;

import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;

public interface RacketService {

	public Racket getRecommendation(RacketForm form);

}

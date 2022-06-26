package com.tta.app.service;

import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;

public interface RacketService {

	public RacketParams getRecommendation(RacketForm form);

}

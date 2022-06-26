package com.tta.app;

import java.util.List;

import com.tta.app.model.events.HitEvent;
import com.tta.app.model.racket.Racket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TtaAppController {
	private final TtaAppService appService;
	
	@Autowired
	public TtaAppController(TtaAppService appService) {
		this.appService = appService;
	}

	@RequestMapping(value = "/history-recommendation/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Racket> getHistoryRecommendation(@PathVariable(required = true) Long userId) {
		Racket r = new Racket();
		return ResponseEntity.ok(r);
	}

	@RequestMapping(value = "/simulation", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> simulation(@RequestBody(required = true) List<HitEvent> hits) {
		String response = appService.simulation(hits);
		return ResponseEntity.ok(response);
	}

}

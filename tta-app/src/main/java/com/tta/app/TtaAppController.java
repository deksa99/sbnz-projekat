package com.tta.app;

import java.util.List;

import com.tta.app.model.User;
import com.tta.app.model.events.HitEvent;
import com.tta.app.model.racket.Blade;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;
import com.tta.app.model.racket.RacketParams;
import com.tta.app.model.racket.Rubber;

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
	
	@RequestMapping(value = "/test/{budget}", method = RequestMethod.GET, produces = "application/json")
	public User test(@PathVariable(required = true) Double budget) {
		User user = new User();
		user.setBudget(budget);
		
		User updated = appService.test(user);
		
		return updated;
	}
	
	// TODO change RacketParams to Racket
	@RequestMapping(value = "/recommendation", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RacketParams> getRecommendation(@RequestBody(required = true) RacketForm form) {
		RacketParams rp = appService.getRecommendation(form);
		return ResponseEntity.ok(rp);
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
	
	@RequestMapping(value = "/blades", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Blade>> getBlades() {
		return ResponseEntity.ok(appService.loadBlades());
	}
	
	@RequestMapping(value = "/rubbers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Rubber>> getRubbers() {
		return ResponseEntity.ok(appService.loadRubbers());
	}
}

package com.tta.app;

import com.tta.app.model.User;
import com.tta.app.model.racket.Racket;
import com.tta.app.model.racket.RacketForm;

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
	
	@RequestMapping(value = "/get-recommendation", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Racket> getRecommendation(@RequestBody(required = true) RacketForm form) {
		var r = new Racket();
		return ResponseEntity.ok(r);
	}
	
	@RequestMapping(value = "/get-history-recommendation/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Racket> getHistoryRecommendation(@PathVariable(required = true) Long userId) {
		var r = new Racket();
		return ResponseEntity.ok(r);
	}
	
	@RequestMapping(value = "/hit", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addHit(@RequestBody(required = true) RacketForm form) {
		return ResponseEntity.ok("OPAA");
	}
}

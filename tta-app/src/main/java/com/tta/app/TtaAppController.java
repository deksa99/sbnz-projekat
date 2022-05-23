package com.tta.app;

import com.tta.app.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TtaAppController {
	private static Logger log = LoggerFactory.getLogger(TtaAppController.class);
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
}

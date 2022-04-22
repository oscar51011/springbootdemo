package com.demo.situation.transactionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/situation/transactionException")
public class TestController {

	@Autowired
	private CallerService callerService;
	
	@RequestMapping("/test")
	public String test() {
		callerService.addJob();
		return "ok";
	}
}

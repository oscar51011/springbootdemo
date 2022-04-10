package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.HelloWorldService;

/**
 * 測試DAO功能運作
 * @author oscar51011
 * @date 2022年1月13日
 */
@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService service;
	
	
	@GetMapping("/test")
	public String testDaoService() throws Exception {
		
		service.testService();
		
		return "ok";
	}
}

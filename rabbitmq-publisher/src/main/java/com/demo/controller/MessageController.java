package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 傳送Queue資訊的restful
 * @author oscar51011
 * @date 2022年1月7日
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

	
	/**
	 * 使用GET的方式快速發送Queue資訊
	 * @param message
	 * @return
	 */
	@GetMapping("/{message}")
	private String publishMessage(@PathVariable String message) {
		return "send message: [ " + message + " ] complete.";
	}
	
}

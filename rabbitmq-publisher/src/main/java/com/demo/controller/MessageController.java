package com.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.MessageDto;
import com.demo.enumeration.QueueEnum;

/**
 * 傳送Queue資訊的restful
 * @author oscar51011
 * @date 2022年1月7日
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	/**
	 * 使用GET的方式快速發送Queue資訊
	 * @param message
	 * @return
	 */
	@GetMapping("/{message}")
	private String publishMessage(@PathVariable String message) {
		
		MessageDto dto = new MessageDto();
		dto.setMessage(message);
		
		rabbitTemplate.convertAndSend(QueueEnum.TARGET.getQueueName(), dto);
		
		return "send message: [ " + message + " ] complete.";
	}
	
}

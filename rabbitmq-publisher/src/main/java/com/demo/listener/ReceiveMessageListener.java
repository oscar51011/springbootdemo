package com.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.demo.dto.MessageDto;

@Component
public class ReceiveMessageListener {
	
	@RabbitListener(queues= "target.queue" )
    public void receive(MessageDto messageDto) {
        System.out.println("receive message from queue:"+ messageDto.toString() );
    }
}

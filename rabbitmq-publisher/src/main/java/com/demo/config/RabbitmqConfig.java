package com.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.enumeration.QueueEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 撰寫rabbitmq的設定檔
 * @author oscar51011
 * @date 2022年1月7日
 */
@Configuration
@EnableRabbit
public class RabbitmqConfig {
	
	/**
	 * 將需要傳遞的物件轉成json格式送出
	 * @param objectMapper
	 * @return
	 */
	@Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
	
	/**
	 * 定義 queue
	 * @return
	 */
	@Bean
    public Queue targetQueue() {
        return new Queue(QueueEnum.TARGET.getQueueName());
    }
}

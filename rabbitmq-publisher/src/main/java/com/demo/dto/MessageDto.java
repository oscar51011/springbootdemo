package com.demo.dto;

import lombok.Data;

/**
 * RabbitMQ 傳遞訊息物件
 * @author oscar51011
 * @date 2022年1月7日
 */
@Data
public class MessageDto {
	/**
	 * 傳遞給queue的資訊
	 */
	private String message;
	
}

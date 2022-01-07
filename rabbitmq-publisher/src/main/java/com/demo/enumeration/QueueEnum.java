package com.demo.enumeration;
/**
 * 建立QueueN的名稱
 * @author oscar51011
 * @date 2022年1月7日
 */
public enum QueueEnum {

	TARGET("target.queue");
	
	private String queueName;
	
	QueueEnum(String queueName) {
		this.queueName = queueName;
	}

	public String getQueueName() {
		return queueName;
	}

}

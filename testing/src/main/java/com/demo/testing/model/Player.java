package com.demo.testing.model;

/**
 * 描述玩家物件
 * @author oscar51011
 * @date 2022年3月9日
 */
public class Player {

	private String name;
	
	private Integer age;

	public Player(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}

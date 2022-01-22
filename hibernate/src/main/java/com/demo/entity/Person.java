package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSON")
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "AGE")
	private Integer age;
	
	/**
	 * 多個使用者中，有相同的職業類別
	 */
	@ManyToOne(cascade=CascadeType.ALL)
    private Job job;
}

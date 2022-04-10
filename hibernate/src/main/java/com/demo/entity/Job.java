package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "JOB")
@Data
public class Job {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(name = "DESCRIPTION")
	private String description;
}

package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.IJob;
import com.demo.dao.IPersonDao;
import com.demo.entity.Job;
import com.demo.entity.Person;

/**
 * 測試DAO功能運作
 * @author oscar51011
 * @date 2022年1月13日
 */
@RestController
@RequestMapping("helloWorld")
public class HelloWorldController {
	
	@Autowired
	IPersonDao personDao;
	
	@Autowired
	IJob jobDao;

	
	@GetMapping("/test")
	public String testDaoService() {
		
		Person person = personDao.getPersonById(1L);
		System.out.println(person.getUserName());
		
		Job job = jobDao.getJobById(1L);
		System.out.println(job.getDescription());
		
		return "ok";
	}
}

package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.demo.dao.IJob;
import com.demo.entity.Job;

@Service
@Transactional
public class HelloWorldService {
		
	@Autowired
	IJob jobDao;
	
	public void testService() throws Exception {
		
		try {
		// 寫入DB
		Job job = new Job();
		job.setId(3L);
		job.setDescription("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
		jobDao.addJob(job);
		} catch (Exception e) {
			throw new Exception("error");
		}
		
		System.out.println("insert done!");
		
		// 打對外服務
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> params = new HashMap<>();
		params.put("age", 1);
		params.put("name", "one");
		String resp = restTemplate.getForObject("http://localhost:8080/requests/getParam?name={name}&age={age}", String.class, params);
	}
}

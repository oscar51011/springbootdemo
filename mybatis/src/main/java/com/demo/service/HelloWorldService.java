package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.demo.entity.Job;
import com.demo.mapper.JobMapper;

@Service
@Transactional
public class HelloWorldService {
	
	@Autowired
	JobMapper jobMapper;

	
	public void testService() {
		
		// 寫入DB
		Job job = new Job();
		job.setId(3L);
		job.setDescription("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
		jobMapper.insert(job);
		// jobMapper.update(job);
		
		System.out.println("update done!");
		
		// 打對外服務
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> params = new HashMap<>();
		params.put("age", 1);
		params.put("name", "one");
		String resp = restTemplate.getForObject("http://localhost:8080/requests/getParam?name={name}&age={age}", String.class, params);
	}
}

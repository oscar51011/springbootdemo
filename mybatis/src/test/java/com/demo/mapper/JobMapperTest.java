package com.demo.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.demo.entity.Job;

@SpringBootTest
class JobMapperTest {
	
	@Autowired
	private JobMapper jobMapper;

	@Test
	void testGetById() {
		System.out.println(jobMapper.getById(2L));
	}
	
	@Test
	void testGetByIdUseXml() {
		System.out.println(jobMapper.getByIdUseXml(2L));
	}
	
	@Test
	void testGetAll() {
		List<Job> jobs = jobMapper.getAll();
		System.out.println(jobs);
	}
	
	@Test
	void testUpdate() {
		Job job = new Job();
		job.setId(2L);
		job.setDescription("test");
		jobMapper.update(job);
		assertTrue("test".equals(jobMapper.getById(2L).getDescription()));
	}

}

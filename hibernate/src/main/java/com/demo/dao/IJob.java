package com.demo.dao;

import com.demo.entity.Job;

/**
 * 宣告 Job DAO 的介面
 * @author oscar51011
 * @date 2022年1月13日
 */
public interface IJob {
	Job getJobById(Long id);
	void addJob(Job job);
	void updateJob(Job job);
}

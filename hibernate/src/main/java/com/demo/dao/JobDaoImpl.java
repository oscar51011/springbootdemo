package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Job;

/**
 * 實作 Job Hibernate DAO
 * @author oscar51011
 * @date 2022年1月13日
 */
@Repository
public class JobDaoImpl implements IJob {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Job getJobById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Job.class, id);
	}

}

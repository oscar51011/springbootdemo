package com.demo.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Job;

/**
 * 實作 Job Hibernate DAO
 * @author oscar51011
 * @date 2022年1月13日
 */
@Repository
@Transactional
public class JobDaoImpl implements IJob {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Job getJobById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Job.class, id);
	}
	
	public void addJob(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.save(job);
	}
	
	public void updateJob(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(job);
	};

}

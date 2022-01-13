package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Person;

/**
 * 實作 Person Hibernate DAO
 * @author oscar51011
 * @date 2022年1月13日
 */
@Repository
public class PersonDaoImpl implements IPersonDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Person getPersonById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Person.class, id);
	}

}

package com.demo.dao;

import com.demo.entity.Person;

/**
 * 宣告 Person DAO 介面
 * @author oscar51011
 * @date 2022年1月13日
 */
public interface IPersonDao {
	Person getPersonById(Long id);
}

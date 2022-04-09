package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 實作 springboot 搭配 mybatis application
 * @author oscar51011
 * @date 2022年4月9日
 */
@SpringBootApplication
@MapperScan("com.demo.mapper")
public class SpringbootMybatisApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}

}

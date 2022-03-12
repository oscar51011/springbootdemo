package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:test.properties")
public class ProjectEnvConfig {

	@Autowired
    Environment environment;
	
	public String getParameterValue(){
        String value = environment.getProperty("project.parameter");
        return value;
    }
}

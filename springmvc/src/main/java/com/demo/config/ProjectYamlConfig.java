package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 讀取自定義 yaml 檔格式內容
 * 
 * @author oscar51011
 * @date 2022年3月12日
 */
@Configuration
@PropertySource(value = "classpath:ymlProject.yml", factory = YamlPropertySourceFactory.class)
public class ProjectYamlConfig {

	@Value("${project.yamlTest}")
	private String parameter;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}

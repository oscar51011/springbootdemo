package com.demo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 定義 RESTFUL API 規範的說明文件設定檔案
 * @author oscar51011
 * @date 2022年1月7日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(this.getApiInfo())
			.enable(true)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.demo.controller"))
			.build()
			;
	}
	
	/**
	 * 描述swagger頁面資訊
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Rabbitmq-Publisher API Documentation",	// title
				"Rabbitmq-Publisher Service",	// desc
				null,	// version
				null,	// ServiceUrl
				new Contact("Sheng Kai Lin", "", ""),	//author Info	
				null,
				null,
				new ArrayList<VendorExtension>());
	}
	
}

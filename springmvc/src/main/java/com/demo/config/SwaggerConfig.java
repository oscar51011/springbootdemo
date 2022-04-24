package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 撰寫Swagger的設定檔
 * @author oscar51011
 * @date 2022年4月23日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${swagger.enable}")
	private boolean swaggerEnable;

	/**
	 * 配置 Swagger 設定
	 * @return
	 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		// 決定是否要顯示預設的 response message ( ex: 200, 201, 403, 404 ...etc )
        		.useDefaultResponseMessages(false)
        		// 設定開關讓配置參數決定swagger是否啟用
        		.enable(swaggerEnable)
        		// swagger Spec 右上角的 Select a spec 顯示之 groupName
        		.groupName("Swagger Demo API")
        		.apiInfo(apiInfo())
        		.select()
        		// 可以透過掃特定 package 顯示
        		.apis(RequestHandlerSelectors.basePackage("com.demo.situation.swaggerExample.controller"))
        		// 可以掃特定的 url 才顯示於 swagger ( 只顯示swaggerTest開頭的 Rest API )
        		.paths(PathSelectors.ant("/swaggerTest/**"))
        		.build()
        		// 定義 swagger API tags 可以用於群組分類
        		.tags(
        			new Tag("User", "the User API with description api tag"),
        			new Tag("Job", "the Job API with description api tag")
        		)
          ;                                           
    }
	
	/**
	 * 配置 Swagger API 資訊
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SWAGGER API規格")
				.description("練習用Swagger呈現API規格")
				.termsOfServiceUrl("test")
				.build()
				;
	}
	
	/**
	 * 設定 Swagger UI 畫面顯示邏輯
	 * @return
	 */
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder()
				.defaultModelsExpandDepth(-1)
				// 如果 submitMethods 放入空陣列，就會把 Try it out 按鈕移除
				// .supportedSubmitMethods(new String[] {})
				.build();
	}
	
}

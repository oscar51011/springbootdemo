package com.demo.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;


/**
 * 使用 java-based 設定檔 , 去設定專案的參數
 * @author oscar51011
 * @date 2022年1月18日
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * Springboot 預設是禁止(;)出現在URL上面，因此為了演示 @MatrixVariable 而把它打開
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}
	
	
}

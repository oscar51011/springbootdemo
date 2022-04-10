package com.demo.controller.request;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用來測試 request 用法:
 * 1. @RequestParam
 * 2. @RequestHeader
 * 3. @RequestAttribute
 * 
 * @author oscar51011
 * @date 2022年1月19日
 */
@RestController
@RequestMapping("/requests")
public class RequestDemoController {

	
	/**
	 * 使用 @RequestHeader 取得請求的 Header 參數
	 * 使用 @RequestParam 將 request 參數 綁定到 method argument
	 * 
	 * 範例: http://localhost:8080/requests/getParam?name=one&age=1
	 * => headerInfo - Accept-Language: zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7
	 * => name: one ,age:1
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	@GetMapping("/getParam")
	public ResponseEntity<String> getParam(
			//@RequestHeader("Accept-Language") String language,
			@RequestParam("name") String name, 
			@RequestParam("age") int age) {
		
		//System.out.println("headerInfo - Accept-Language: " + language);
		
		System.out.println("name: " + name + " ,age:" + age);
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * 參數帶入的為一個清單，可以用逗號(,)分隔，並用陣列的形式把資料接近來
	 * 範例: http://localhost:8080/requests/getParamByMultipleValue?names=one,two,three
	 * => name: one
     *    name: two
	 *	  name: three
	 * 
	 * @param names
	 * @return
	 */
	@GetMapping("/getParamByMultipleValue")
	public ResponseEntity<String> getParam(
			@RequestParam("names") String[] names) {
	
		for(String name: names) {
			System.out.println("name: " + name);
		}
		
		return ResponseEntity.ok("demo success");
	}
	
	
	/**
	 * 使用 Map 去接 HTTP request header 的參數
	 * 
	 * 範例: http://localhost:8080/requests/listHttpHeadersByMap
	 * 
	 * @param names
	 * @return
	 */
	@GetMapping("/listHttpHeadersByMap")
	public ResponseEntity<String> getHttpHeaderByMap(
			@RequestHeader Map<String, String> headers) {
	
		headers.forEach((key, value)->{
			System.out.println("header key:" + key + " ,value:" + value);
		});
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * 將 HTTP request header 參數封裝成 HttpHeaders 物件
	 * 
	 * 範例: http://localhost:8080/requests/getHttpHeadersByHttpHeaders
	 * 
	 * @param names
	 * @return
	 */
	@GetMapping("/getHttpHeadersByHttpHeaders")
	public ResponseEntity<String> getHttpHeaderByHttpHeaders(
			@RequestHeader HttpHeaders headers) {
	
		System.out.println( "host:" + headers.getHost().getHostName() + ", port:" + headers.getHost().getPort());
		
		return ResponseEntity.ok("demo success");
	}
	
}

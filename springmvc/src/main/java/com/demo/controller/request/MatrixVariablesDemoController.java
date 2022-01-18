package com.demo.controller.request;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用來測試 request 參數 @MatrixVariable 用法
 * 
 * 其參數組成為 key/value , 
 * - 使用 "等號"(=) 來取對應的值
 * - 使用 "分號"(;) 來定義不同族群
 * - 使用 "逗號"(,) 來區分多筆資料
 * 
 * ※ 因為 Spring boot 預設是禁止 (;) 出現在URL上，因此要撰寫設定檔去覆寫預設規則
 * com.demo.controller.config.WebMvcConfig
 * 
 * 
 * @author oscar51011
 * @date 2022年1月18日
 */
@RestController
@RequestMapping("/matrixVariables")
public class MatrixVariablesDemoController {
	
	/**
	 * 單筆參數傳進來
	 *
	 * 範例: http://localhost:8080/matrixVariables/job/job=doctor
	 * => value: doctor
	 * 
	 * @param job
	 */
	@GetMapping("/job/{jobParam}")
	public ResponseEntity<String> singleJobParam(@MatrixVariable String job) {
		System.out.println("value: " +  job );
		
		return ResponseEntity.ok("demo success");
	}
		
	/**
	 * 利用逗號(,)將參數變成陣列的形式傳進來
	 * 
	 * 範例: http://localhost:8080/matrixVariables/jobs/job=doctor,test
	 * => value: doctor | test
	 * 
	 * @param job
	 */
	@GetMapping("/jobs/{jobParam}")
	public ResponseEntity<String> multipleJobParam(@MatrixVariable String[] job) {
		System.out.println("value: " +  job[0] + " | " + job[1]);
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * 利用 @PathVariable 參數帶進來，並用 @MatrixVariable 進行資料補充
	 * 
	 * 範例: http://localhost:8080/matrixVariables/complementPathVariable/John;job=doctor;age=30
	 * => 姓名: John ,職業: doctor ,年齡:30
	 * 
	 * @param name
	 * @param job
	 * @param age
	 */
	@GetMapping("/complementPathVariable/{name}")
	public ResponseEntity<String> complementPathVariable(
			@PathVariable String name,
			@MatrixVariable String job,
			@MatrixVariable int age) {
		System.out.println("姓名: " +  name + " ,職業: " + job + " ,年齡:" + age);
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * @MatrixVariable 可以設計成非必填，因此可以根據不同的參數擁有不同結果
	 * 
	 * 範例1: http://localhost:8080/matrixVariables/matrixVariablesNotRequired/John
	 * => 姓名: John ,職業: Value Not Found!
	 * 
	 * 範例2: http://localhost:8080/matrixVariables/matrixVariablesNotRequired/John;job=doctor
	 * => 姓名: John ,職業: doctor
	 * 
	 * @param name
	 * @param job
	 * @param age
	 */
	@GetMapping("/matrixVariablesNotRequired/{name}")
	public ResponseEntity<String> complementPathVariable(
			@PathVariable String name,
			@MatrixVariable(required = false, defaultValue="Value Not Found!") String job) {
		System.out.println("姓名: " +  name + " ,職業: " + job );
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * 範例: http://localhost:8080/matrixVariables/people/John;age=30/pet/doggy;age=2
	 * => 姓名: John 年齡: 30
	 *    寵物名: doggy 年齡: 2
	 * 
	 * 如果再URL底下有不同字段的 @MatrixVariables , 可以使用 參數 pathVar & 對應的參數 name 來區分
	 * 
	 * @param name
	 * @param job
	 * @param age
	 */
	@GetMapping("/people/{name}/pet/{petName}")
	public ResponseEntity<String> segmentDifferentPathMatrixVariables (
			@PathVariable String name,
			@PathVariable String petName,
			@MatrixVariable(name = "age", pathVar= "name") int age,
			@MatrixVariable(name = "age", pathVar= "petName") int petAge) {
		
		System.out.println("姓名: " +  name + " 年齡: " + age );
		System.out.println("寵物名: " + petName + " 年齡: " + petAge);
		
		return ResponseEntity.ok("demo success");
	}
	
	/**
	 * @MatrixVariable 參數也可以使用 MultiValueMap 型態來接
	 * 可適用在 一個key 對應 多個value 的時候使用
	 * 
	 * 範例: http://localhost:8080/matrixVariables/multiValueMapDemo/dog/age=30;name=John/cat/age=20;name=May
	 * => key: age ,value: [30, 20]
	 *	  key: name ,value: [John, May]	
	 * 上述範例 request 為喜歡狗 & 貓的名單 ， 資料傳進來就可以立即分辨喜歡貓狗的飼主 年齡 & 名字清單
	 *
	 *
	 * @param matrixVars
	 * @param petMatrixVars
	 * @return
	 */
	@GetMapping("/multiValueMapDemo/dog/{dogOwner}/cat/{catOwner}")
	public ResponseEntity<String> multiValueMapDemo (
			@MatrixVariable MultiValueMap<String, String> matrixVars) {
		
		for(String key : matrixVars.keySet()) {
			System.out.println("key: " + key + " ,value: " + matrixVars.get(key));
		}
		
		//System.out.println("姓名: " +  name + " 年齡: " + age );
		//System.out.println("寵物名: " + petName + " 年齡: " + petAge);
		
		return ResponseEntity.ok("demo success");
	}	
}

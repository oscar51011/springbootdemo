package com.demo.controller.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用來測試 @ModelAttribute 特性
 * 
 * @author oscar51011
 * @date 2022年1月20日
 */
@Controller
@RequestMapping("/modelAttributeDemo")
public class ModelAttributeDemoController {

	/**
	 * @ModelAttribute 放在 method argument時，作法等同於在程式內 model addAttribute的效果，做資料綁定的動作
	 * 範例: http://localhost:8080/modelAttributeDemo/methodArgumentAnnotation/{輸入任意值}
	 * 
	 * @return
	 */
	@GetMapping("/methodArgumentAnnotation/{name}")
	public String useMethodArgumentAnnotation(@ModelAttribute("name") String name){
		
		// @ModelAttribute("name") 作法等同於 model.addAttribute("name", name);
		
		return "modelDemo/methodArgumentAnnotationDemo";
	}
	
	/**
	 * @ModelAttribute 放在 method Level 的時候，會在 @RequestMapping 載入前，就被載入
	 * 因此整個 class 的參數都會加上 msg 的參數， 因此就算沒有在 該 method 設定 addAttribute 也能夠吃到參數
	 * 
	 * 
	 * 範例: http://localhost:8080/modelAttributeDemo/methodLevelAnnotation
	 * 
	 * @return
	 */
	@GetMapping("/methodLevelAnnotation")
	public String useMethodLevelAnnotation(){
		return "modelDemo/methodLevelAnnotationDemo";
	}
	
	
	/**
	 * 初始化在 requestMapping 使用時
	 * 
	 * As a method-level annotation in @Controller or @ControllerAdvice classes that help 
	 * to initialize the model prior to any @RequestMapping method invocation.
	 * 
	 * @param model
	 */
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }
	
	
	
}

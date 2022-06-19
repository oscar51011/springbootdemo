package com.demo.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/excel")
public class ExcelUploadController {

	/**
	 * 顯示檔案上傳頁面
	 * @return
	 */
	@GetMapping("/show")
	public String show() {
		return "/excel/show";
	}
	
	/**
	 * 操作檔案上傳動作
	 * @param file
	 * @throws IOException 
	 */
	@PostMapping("/upload")
	public String uploadImage(Model model,MultipartFile file) throws IOException {
		
		String fileName = file.getOriginalFilename();
		
		System.out.println(fileName);
		
		model.addAttribute("result", "ok");
		
		return "/excel/result";
	}
	
}

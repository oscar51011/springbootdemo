package com.demo.generator;

import java.io.File;

/**
 * 初始化, 需建立對應的 package　以利放置input/output
 * 
 * @author oscar51011
 * @date 2023年2月6日
 */
public class CodeGeneratorInitial {
	public static void main(String[] args) {
		
		System.out.println("Code Generator 初始化開始:");
		
		File inputDir = new File(CodeGeneratorUtils.getAbsoluteCodeGeneratorPath("input"));
		File outputDir = new File(CodeGeneratorUtils.getAbsoluteCodeGeneratorPath("output"));
		
		System.out.println(inputDir.mkdir()?"建立input資料夾":"input資料夾已存在");
		System.out.println(outputDir.mkdir()?"建立output資料夾":"output資料夾已存在");
	
		System.out.println("Code Generator 初始化結束!");
	}
}
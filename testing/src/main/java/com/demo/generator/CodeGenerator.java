package com.demo.generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * code generator
 * @author oscar51011
 * @date 2023年2月5日
 */
public class CodeGenerator {
	
	private static final String RESULT_DIR = "C:\\Users\\88691\\Desktop\\codeGenerator\\result";

	private static final String RESULT_DIR_FILE = "file:\\Users\\88691\\Desktop\\codeGenerator\\result";

	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		// step1: 輸入欲產出檔名
		//Scanner scanner = new Scanner(System.in);
		//System.out.println("create java file name:");
		//String dtoName = scanner.next();
		
		// step2: 讀取檔案轉換成 json String
		final StringBuffer jsonString = readJsonFile();
				
		ObjectMapper mapper = new ObjectMapper();
		
		// 建立檔案		
		FileWriter fw = new FileWriter(CodeGeneratorUtils.getAbsoluteCodeGeneratorPath("output")+"\\Test.java");
		
		
		JsonNode jsonNode = mapper.readTree(jsonString.toString());
		Iterator<Entry<String, JsonNode>> iterator = jsonNode.fields();
		fw.write(CodeGeneratorUtils.createPackageImportString());
		fw.write(CodeGeneratorUtils.createClassStartBlock("Test"));
	
		while(iterator.hasNext()) {
			
			Entry<String, JsonNode> node = iterator.next();
			
			System.out.println(node.getKey()); // 檢查key值
	    	// 判斷參數型態
	    	System.out.println("是否有值:"+node.getValue().isValueNode()); // 檢查是否為 value
	    	if(node.getValue().isValueNode()) {
	    		fw.write("public String " + node.getKey() + ";");
	    		fw.write("\n\n");
	    	}
	    	
	    	System.out.println("是否為array:" + node.getValue().isArray());
  	
	    	Iterator<Entry<String, JsonNode>> iterator2 = node.getValue().fields();
	    	while(iterator2.hasNext()) {
	    		Entry<String, JsonNode> inode = iterator2.next();
	    		System.out.println("inner是否有值:"+inode.getValue().isValueNode()); // 檢查是否為 value
	    		
	    		Iterator<Entry<String, JsonNode>> iterator3 = inode.getValue().fields();
	    		while(iterator3.hasNext()) {
	    			Entry<String, JsonNode> anode = iterator3.next();
	    			System.out.println("array是否有值:"+anode.getValue().isValueNode()); // 檢查是否為 value
	    			System.out.println("array是否為陣列:"+anode.getValue().isArray()); // 檢查是否為 value
	    			
	    			if(anode.getValue().isArray()) {
	    				System.out.println(anode.getValue());
	    				System.out.println("處理jsonArray");
	    				
	    				Iterator<JsonNode> arrays = anode.getValue().elements();
	    				JsonNode content = arrays.next();
	    				Iterator<Entry<String, JsonNode>> iterator4 = content.fields();
	    				while(iterator4.hasNext()) {
	    					Entry<String, JsonNode> a2node = iterator4.next();
	    					System.out.println("arr內的值:"+a2node.getKey());
	    				}
	    			}
	    			
	    			    			
	    		}
	    	}
	    	
	    	
	    	//System.out.println("是否文字:"+e.getValue().isTextual());
	    	//System.out.println("是否數字:"+e.getValue().isInt());
	    	//System.out.println("是否數字2:"+e.getValue().isIntegralNumber());
	    	//System.out.println("是否Long:"+e.getValue().isLong());
	    	//System.out.println("是否浮點數:"+e.getValue().isDouble());
	    	//System.out.println("是否布林值:"+e.getValue().isBoolean());
	    	//System.out.println("是否bigDecimal:"+e.getValue().isBigDecimal());
	    	//System.out.println(e.getValue().isArray()); // 檢查是否為陣列
		}
	    
	    fw.write(CodeGeneratorUtils.createClassEndBlock());
	    fw.close();
	    
	    Thread.sleep(5);
	    
	    // createSetterGetter();
		
	}

	/**
	 * 使用 java 反射產生對應的 Setter / Getter
	 * 
	 * @throws ClassNotFoundException
	 */
	private static void createSetterGetter() throws ClassNotFoundException {
		// 將dto加上getter/setter
	    Class<?> clazz =  Class.forName(CodeGenerator.class.getPackage().getName() + ".output.Test");
	    Field[] fields = clazz.getDeclaredFields();
	    for (Field field : fields) {
			String name = field.getName();
			String type = field.getType().getSimpleName();
			
			System.out.println("名稱:" + name + ", 類型:" + type);
		}
	}

	/**
	 * 讀取Json檔案
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static StringBuffer readJsonFile() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(CodeGeneratorUtils.getAbsoluteCodeGeneratorPath("input")+"\\test.json");
		final StringBuffer jsonString = new StringBuffer(2048);
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			jsonString.append(br.readLine());
		}
		fr.close();
		return jsonString;
	}
	
}

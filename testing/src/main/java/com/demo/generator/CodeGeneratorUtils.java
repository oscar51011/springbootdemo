package com.demo.generator;

/**
 * 產生 code generator 的 方法
 * hint: getAbsoluteCodeGeneratorPath() 依照不同專案有不同的配置,此用法目前適用於 sprintboot 專案結構
 * 
 * @author oscar51011
 * @date 2023年2月6日
 */
public class CodeGeneratorUtils {
	
	public static void main(String[] args) throws ClassNotFoundException {
		 Class<?> clazz =  Class.forName(CodeGenerator.class.getPackage().getName() + ".output.Test");
	}
	
	private static final String BASE_BEAN_PACKAGE = CodeGenerator.class.getPackage().getName();
	
	public static String getAbsoluteCodeGeneratorPath(String deeperPackageName) {
		
		String pathSign = isOsWindow() ? "\\" : "/";
		
		StringBuffer absolutePath = new StringBuffer();
		// project location
		absolutePath.append(System.getProperty("user.dir"));
		absolutePath.append(pathSign);
		absolutePath.append("src");
		absolutePath.append(pathSign);
		absolutePath.append("main");
		absolutePath.append(pathSign);
		absolutePath.append("java");
		absolutePath.append(pathSign);
		String folderPath = CodeGenerator.class.getPackage().getName();
		folderPath = folderPath.replace(".", pathSign);
		absolutePath.append(folderPath);
		absolutePath.append(pathSign);
		absolutePath.append(deeperPackageName);
		return absolutePath.toString();
	}
	
	/**
	 * example:
	 * 
	 * package com.demo.generator.output;
	 * 
	 * @return
	 */
	public static String createPackageImportString() {
		StringBuffer buffer = new StringBuffer();
		String folderPath = CodeGenerator.class.getPackage().getName();
		buffer.append("package ").append(folderPath).append(".output;");
		buffer.append("\n\n");
		return buffer.toString();
	}
	
	/**
	 * example:
	 * 
	 * public class MyTest extends BaseBean {
	 * 
	 * 
	 * @param className
	 * @return
	 */
	public static String createClassStartBlock(String className) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("import ").append(BASE_BEAN_PACKAGE).append(".BaseBean;").append("\n");
		buffer.append("public class " + getFieldNameFirstLineUpperCase(className) + " extends BaseBean {");
		buffer.append("\n\n");
		return buffer.toString();
	}
	
	/**
	 * example:
	 * 
	 * }
	 * 
	 * @return
	 */
	public static String createClassEndBlock() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("}");
		return buffer.toString();
	}

	/**
	 * example:
	 * 
	 * public void settest(String test) {
	 *		this.test = test;
	 *	}
	 *
	 * @param fieldName
	 * @param type
	 * @return
	 */
	public static String createSetterString(String fieldName, String type) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("public void");
		buffer.append(" set").append(getFieldNameFirstLineUpperCase(fieldName));
		buffer.append("("+ type + " " + fieldName + ") {\n");
		buffer.append("\t" + "this." + fieldName + " = " + fieldName + ";\n");
		buffer.append("}\n");
		
		return buffer.toString();
	}
	
	/**
	 * example:
	 * 
	 * public String getTest() {
	 *		return test;
	 *	}
	 * 
	 * @param fieldName
	 * @param type
	 * @return
	 */
	public static String createGetterString(String fieldName, String type) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("public " + type);
		buffer.append(" get").append(getFieldNameFirstLineUpperCase(fieldName));
		buffer.append("() {\n");
		buffer.append("\t" + "return " + fieldName + ";\n");
		buffer.append("}\n");	
		return buffer.toString();
	}
	
	/**
	 * example:
	 * 
	 * fieldName: test => Test
	 * 
	 * @param fieldName
	 * @return
	 */
	private static String getFieldNameFirstLineUpperCase(String fieldName) {
		return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
	}
	
	/**
	 * 檢查作業系統是否為 window: 用來判斷 folder 是用 \(window) 或 /(linux)
	 * @return
	 */
	private static boolean isOsWindow() {
		String os = System.getProperty("os.name").toLowerCase();
		return ( os.indexOf("win") >= 0);
	}
}

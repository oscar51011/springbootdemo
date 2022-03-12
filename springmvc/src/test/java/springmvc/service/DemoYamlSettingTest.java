package springmvc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.SpringMvcApplication;
import com.demo.config.ProjectYamlConfig;

@SpringBootTest(classes = {SpringMvcApplication.class})
class DemoYamlSettingTest {
	
	@Autowired
	private ProjectYamlConfig projectYamlConfig;

	@Test
	void testYamlSettingCase() {
		System.out.println("load @Value:" + projectYamlConfig.getParameter());
	}
}

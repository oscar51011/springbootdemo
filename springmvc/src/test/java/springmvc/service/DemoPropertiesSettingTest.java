package springmvc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.SpringMvcApplication;
import com.demo.config.ProjectConfig;
import com.demo.config.ProjectConfigurationPropertiesConfig;
import com.demo.config.ProjectEnvConfig;

@SpringBootTest(classes = {SpringMvcApplication.class})
class DemoPropertiesSettingTest {
	
	@Autowired
	private ProjectConfig projectConfig;
	
	@Autowired
	private ProjectEnvConfig projectEnvConfig;
	
	@Autowired
	private ProjectConfigurationPropertiesConfig projectConfigurationPropertiesConfig;
	
	@Test
	void testPropertiesSettingCase() {
		System.out.println("load @Value:" + projectConfig.getParameter());
		System.out.println("load Enviroment interface:" + projectEnvConfig.getParameterValue());
		System.out.println("load @ConfigurationProperties:" + projectConfigurationPropertiesConfig.getParameter());

	}
}

package org.thepurplelabsinc.oauth2.sampleapplication;

import org.thepurplelabsinc.oauth2.resourceserver.prop.ResourceServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"org.thepurplelabsinc.oauth2.sampleapplication", "org.thepurplelabsinc.oauth2.resourceserver"})
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Autowired
	private ResourceServerProperties resourceServerProperties;
	
	@GetMapping("/user/message")
	public String userMessage() {
		return resourceServerProperties.getMessage() + " for the user";
	}
	
	@GetMapping("/admin/message")
	public String adminMessage() {
		return resourceServerProperties.getMessage() + " for the admin";
	}

}

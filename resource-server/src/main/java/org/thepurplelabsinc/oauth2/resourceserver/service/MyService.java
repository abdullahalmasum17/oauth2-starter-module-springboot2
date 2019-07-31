package org.thepurplelabsinc.oauth2.resourceserver.service;

import org.thepurplelabsinc.oauth2.resourceserver.prop.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ResourceServerProperties.class)
public class MyService {

//	@Autowired
	private final ResourceServerProperties resourceServerProperties;
	
	public MyService(ResourceServerProperties resourceServerProperties) {
		this.resourceServerProperties = resourceServerProperties;
	}
	
	public String message() {
		System.out.println(resourceServerProperties.getMessage());
		return this.resourceServerProperties.getMessage();
	}
	
	
	
}

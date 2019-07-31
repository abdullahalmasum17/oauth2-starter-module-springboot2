//package com.sbsatter.oauth2.resourceserver;
//
//import ResourceServerProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@SpringBootApplication
//@RestController
//public class OAuth2ResourceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(OAuth2ResourceApplication.class, args);
//	}
//
//	@Autowired
//	private ResourceServerProperties serviceProperties;
//
//	@GetMapping("/")
//	public String message() {
//		return serviceProperties.getMessage();
//	}
//}

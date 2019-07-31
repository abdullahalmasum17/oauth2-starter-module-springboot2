//package com.sbsatter.oauth2.resourceserver.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
//
///**
// * Created by sbsatter on 6/12/18.
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
//public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {
////	@Autowired
////	private OAuth2SecurityConfiguration configuration;
//
//	@Override
//	public MethodSecurityExpressionHandler createExpressionHandler() {
//		return new OAuth2MethodSecurityExpressionHandler();
//	}
//}

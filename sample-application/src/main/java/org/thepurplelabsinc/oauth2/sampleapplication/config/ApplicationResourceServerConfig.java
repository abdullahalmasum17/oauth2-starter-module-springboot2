package org.thepurplelabsinc.oauth2.sampleapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.thepurplelabsinc.oauth2.resourceserver.config.ResourceServerConfiguration;

@Configuration
public class ApplicationResourceServerConfig extends ResourceServerConfiguration {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.requestMatchers().antMatchers("/**")
				.and().authorizeRequests()
				.antMatchers("/admin")
				.hasRole("ADMIN")
				.antMatchers("/user")
				.hasRole("USER")
				.anyRequest().authenticated()
//				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
		;
	}
}

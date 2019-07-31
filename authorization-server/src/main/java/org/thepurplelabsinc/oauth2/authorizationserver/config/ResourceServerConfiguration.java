package org.thepurplelabsinc.oauth2.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by sbsatter on 6/12/18.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//	private static final String RESOURCE_ID = "my-rest-api";

//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(RESOURCE_ID).stateless(false);
//	}
	
	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.requestMatchers().antMatchers("/**")
				.and().authorizeRequests()
				.antMatchers("/**").hasRole("USER")
				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
		;
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	
	}

}

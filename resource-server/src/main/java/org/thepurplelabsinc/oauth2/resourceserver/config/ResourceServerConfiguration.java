package org.thepurplelabsinc.oauth2.resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

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


//	@Bean
//	public ResourceServerProperties serviceProperties(ResourceServerProperties resourceServerProperties) {
//		return resourceServerProperties;
//	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.requestMatchers().antMatchers("/**")
				.and().authorizeRequests()
				.antMatchers("/**").authenticated()
//				.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
		;
	}
	
	
	@Override
	public final void configure(ResourceServerSecurityConfigurer configurer) {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8085/oauth/check_token");
		remoteTokenServices.setClientId("client1");
		remoteTokenServices.setClientSecret("secret");
//		remoteTokenServices.readAccessToken()
		configurer.tokenServices(remoteTokenServices);
	}

}

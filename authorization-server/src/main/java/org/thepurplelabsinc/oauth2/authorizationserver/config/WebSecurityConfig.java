package org.thepurplelabsinc.oauth2.authorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by sbsatter on 6/12/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER").build(),
				User.withUsername("admin").password(passwordEncoder().encode("password")).roles("ADMIN").build()
		);
	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//				.anonymous().disable()
//				.csrf().disable();
//				.authorizeRequests().antMatchers("/oauth/**").hasRole("USER");
//				.antMatchers("/oauth/token/", "/oauth/authorize/").permitAll();
//	}
//
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
//	@Bean
//	public TokenStore tokenStore() {
//		return new InMemoryTokenStore();
//	}
//
//	@Bean
//	@Autowired
//	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
//		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
//		handler.setTokenStore(tokenStore);
//		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//		handler.setClientDetailsService(clientDetailsService);
//		return handler;
//	}
//
//	@Bean
//	@Autowired
//	public ApprovalStore approvalStore(TokenStore tokenStore) {
//		TokenApprovalStore approvalStore = new TokenApprovalStore();
//		approvalStore.setTokenStore(tokenStore);
//		return approvalStore;
//	}
	
}

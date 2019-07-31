//package com.sbsatter.oauth2.resourceserver.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//
///**
// * Created by sbsatter on 6/12/18.
// */
//@Configuration
//@EnableWebSecurity
//public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////	@Autowired
////	private ClientDetailsService clientDetailsService;
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//
//	@Autowired
////	AuthenticationManagerBuilder builder;
//	public void globalUserDetails(AuthenticationManagerBuilder builder) throws Exception {
//		builder.inMemoryAuthentication()
//				.withUser("bill").password("{noop}abc123").roles("ADMIN")
//				.and()
//				.withUser("bob").password("{noop}abc123").roles("USER");
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//				.anonymous().disable()
//				.csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/oauth/token/").permitAll();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public TokenStore tokenStore() {
//		return new InMemoryTokenStore();
//	}
//
////	@Bean
////	@Autowired
////	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
////		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
////		handler.setTokenStore(tokenStore);
////		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
////		handler.setClientDetailsService(clientDetailsService);
////		return handler;
////	}
//
////	@Bean
////	@Autowired
////	public ApprovalStore approvalStore(TokenStore tokenStore) {
////		TokenApprovalStore approvalStore = new TokenApprovalStore();
////		approvalStore.setTokenStore(tokenStore);
////		return approvalStore;
////	}
//
//}

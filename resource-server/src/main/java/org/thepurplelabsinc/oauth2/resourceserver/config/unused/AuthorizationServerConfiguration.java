//package com.sbsatter.oauth2.resourceserver.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * Created by sbsatter on 6/12/18.
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//	private static final String REALM = "MY_OAUTH_REALM";
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private TokenStore tokenStore;
//
//	@Autowired
//	private UserApprovalHandler userApprovalHandler;
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.realm(REALM + "/client");
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients
//				.inMemory()
//				.withClient("my-trusted-client")
//				.authorizedGrantTypes("password", "refresh_token")
//				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.scopes("read", "write", "trust")
//				.secret("{noop}secret")
//				.accessTokenValiditySeconds(120) // 2 minutes
//				.refreshTokenValiditySeconds(600); // 5 minutes
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager);
//	}
//}

package org.thepurplelabsinc.oauth2.authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created by sbsatter on 6/12/18.
 */
@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer configurer) {
//		configurer.realm(REALM + "/client");
		// necessary to allow remote tokens from being checked and validated
		configurer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')").checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
				.inMemory()
				.withClient("client1")
				.authorizedGrantTypes("password", "refresh_token")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
				.scopes("read", "write", "trust")
				.secret(passwordEncoder.encode("secret"))
				.accessTokenValiditySeconds(1 * 60) // 2 minute
				.refreshTokenValiditySeconds(3 * 60); // 1 hour
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
				// necessary to configure the token store, otherwise same server resource server can not access it
				.tokenStore(tokenStore())
				//.tokenServices(tokenServices()).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager)
				// necessary to generate
				.userDetailsService(userDetailsService);
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setReuseRefreshToken(false);
		defaultTokenServices.setSupportRefreshToken(true);
//		defaultTokenServices.setTokenEnhancer(accessTokenConverter());
		defaultTokenServices.setAccessTokenValiditySeconds(1);
		defaultTokenServices.setRefreshTokenValiditySeconds(10);
		return defaultTokenServices;
	}

}

package org.thepurplelabsinc.oauth2.authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"org.thepurplelabsinc.oauth2.authorizationserver"})
@EnableTransactionManagement
@EnableAuthorizationServer
public class AuthorizationServer {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServer.class, args);
	}
}

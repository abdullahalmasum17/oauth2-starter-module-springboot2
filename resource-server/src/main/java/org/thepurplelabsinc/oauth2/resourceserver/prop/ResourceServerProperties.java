package org.thepurplelabsinc.oauth2.resourceserver.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("resource-server")
public class ResourceServerProperties {
	
	/**
	 * A message for the service.
	 */
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}

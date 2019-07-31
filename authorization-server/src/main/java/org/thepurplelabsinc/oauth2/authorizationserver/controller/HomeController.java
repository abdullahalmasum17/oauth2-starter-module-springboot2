package org.thepurplelabsinc.oauth2.authorizationserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sbsatter on 6/12/18.
 */
@Controller
@RequestMapping("/user")
public class HomeController {
	
	@RequestMapping("/findAll")
	public ResponseEntity<List<String>> findAllUsers() {
		String [] users = new String[] {"Curtois", "KDB", "Kompany", "Eden Hazard", "Thorgan Hazard"};
		return new ResponseEntity<>(Arrays.asList(users), HttpStatus.OK);
	}
	
	@RequestMapping("/auth")
	public String showAuthPage() {
		return "auth";
	}
	
}

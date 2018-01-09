package com.wttechnologies.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login-page")
	public String showLogin(){
		
		return "login-page";
	}
}
package com.wttechnologies.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wttechnologies.spring.web.dao.User;

@Controller
public class LoginController {

	@RequestMapping("/login-page")
	public String showLogin() {

		return "login-page";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping("/createaccount")
	public String createAccount() {

		return "accountcreated";
	}
}

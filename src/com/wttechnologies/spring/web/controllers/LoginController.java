package com.wttechnologies.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wttechnologies.spring.web.dao.FormValidationGroup;
import com.wttechnologies.spring.web.dao.User;
import com.wttechnologies.spring.web.service.UserService;

@Controller
public class LoginController {

	// Declarations
	UserService userService;

	@RequestMapping("/login-page")
	public String showLogin() {

		return "login-page";
	}

	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}

	@RequestMapping("/loggedout")
	public String showLoggedOut() {

		return "loggedout";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@Validated(FormValidationGroup.class) User user, BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(true);

		if (userService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}

		try {
			userService.create(user);
		} catch (DuplicateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "newaccount";
		}

		return "accountcreated";
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

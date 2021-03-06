package com.wttechnologies.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wttechnologies.spring.web.dao.Offer;
import com.wttechnologies.spring.web.dao.User;
import com.wttechnologies.spring.web.service.OffersService;
import com.wttechnologies.spring.web.service.UserService;

@Controller
public class HomeController {

	// Properties
	@Autowired
	UserService userService;
	@Autowired
	private OffersService offersService;
	NamedParameterJdbcTemplate jdbc;
	private static Logger logger = Logger.getLogger(HomeController.class);

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		logger.info("Showing home page");

		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		
		boolean hasOffer = false;
		
		if(principal != null) {
			hasOffer = offersService.hasOffer(principal.getName());
		}
		
		model.addAttribute("hasOffer", hasOffer);
		
		return "home";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin";
	}
}

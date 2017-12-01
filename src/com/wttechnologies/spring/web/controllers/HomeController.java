package com.wttechnologies.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wttechnologies.spring.web.service.OffersService;

@Controller
public class HomeController {

	// Properties
	private OffersService offersService;

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
}

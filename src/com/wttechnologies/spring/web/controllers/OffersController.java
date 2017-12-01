package com.wttechnologies.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wttechnologies.spring.web.dao.Offer;
import com.wttechnologies.spring.web.service.OffersService;

@Controller
public class OffersController {

	// Properties
	private OffersService offersService;

	// Default Constructor
	public OffersController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/params", method=RequestMethod.GET)
	public String showParams(@RequestParam("id") String id) {
		System.out.println("Id is: " + id);
		return "params";
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		return "createoffer";
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

}
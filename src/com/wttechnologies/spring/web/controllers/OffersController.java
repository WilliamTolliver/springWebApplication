package com.wttechnologies.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wttechnologies.spring.web.dao.FormValidationGroup;
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

	@RequestMapping(value = "/params", method = RequestMethod.GET)
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
	public String createOffer(Model model, Principal principal) {

		Offer offer = null;

		if (principal != null) {
			String username = principal.getName();
			offer = offersService.findOffer(username);
		}

		if (offer == null) {
			offer = new Offer();
		}
		model.addAttribute("offer", offer);
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Validated(value=FormValidationGroup.class) Offer offer, BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {
		if (result.hasErrors()) {
			return "createoffer";
		}

		if (delete == null) {
			String username = principal.getName();
			offer.getUser().setUsername(username);

			offersService.saveOrUpdate(offer);

			return "offercreated";
		} else {
			offersService.delete(offer.getId());
			return "offerdeleted";
		}
	}

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

}

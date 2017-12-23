package com.wttechnologies.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wttechnologies.spring.web.dao.Offer;
import com.wttechnologies.spring.web.dao.OffersDAO;

@Service
public class OffersService {

	// Properties
	private OffersDAO offersDAO;

	public List<Offer> getCurrent() {
		return offersDAO.getOffers();
	}

	@Autowired
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	}
	
	public void createOffer(Offer offer) {
		offersDAO.create(offer);
	}
	
	public void throwTextException() {
		offersDAO.findOffer(99999);
	}
}

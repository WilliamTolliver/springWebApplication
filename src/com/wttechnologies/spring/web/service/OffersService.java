package com.wttechnologies.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	public void createOffer(Offer offer) {
		offersDAO.saveOrUpdate(offer);
	}

	public boolean hasOffer(String name) {
		// TODO Auto-generated method stub
		if (name == null) {
			return false;
		}
		List<Offer> offers = offersDAO.getOffers(name);

		if (offers.size() == 0) {
			return false;
		}

		return true;
	}

	public Offer findOffer(String username) {

		if (username == null) {
			return null;
		}
		List<Offer> offers = offersDAO.getOffers(username);

		if (offers.size() == 0) {
			return null;
		}

		// TODO Auto-generated method stub
		return offers.get(0);
	}

	public void saveOrUpdate(Offer offer) {
		// TODO Auto-generated method stub
		offersDAO.saveOrUpdate(offer);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		offersDAO.delete(id);
	}

}

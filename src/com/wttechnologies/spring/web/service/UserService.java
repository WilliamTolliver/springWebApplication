package com.wttechnologies.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wttechnologies.spring.web.dao.Offer;
import com.wttechnologies.spring.web.dao.OffersDAO;
import com.wttechnologies.spring.web.dao.User;
import com.wttechnologies.spring.web.dao.UserDAO;

@Service("userService")
public class UserService {

	// Properties
	private UserDAO userDAO;

	@Autowired
	public void setOffersDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void create(User user) {
		userDAO.create(user);
	}

	public boolean exists(String username) {
		// TODO Auto-generated method stub
		return userDAO.exists(username);
	}

}

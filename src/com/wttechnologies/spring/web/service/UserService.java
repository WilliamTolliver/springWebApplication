package com.wttechnologies.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

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

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userDAO.getAllUsers();
		return users ;
	}

}

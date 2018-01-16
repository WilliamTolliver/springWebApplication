package com.wttechnologies.spring.web.dao;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDAO")
public class UserDAO {

	// Properties
	private NamedParameterJdbcTemplate jdbc;

	public UserDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully loaded OffersDAO");
	}

	// Configured Basic DataSource from JDBC
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean create(User user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		jdbc.update("INSERT into users (username, password, email) VALUES(:username, :password, :email)", params);

		return jdbc.update("INSERT into authorities (username, authority) VALUES(:username, :authority)", params) == 1;

	}

	public boolean exists(String username) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT count(*) FROM users WHERE username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}
}
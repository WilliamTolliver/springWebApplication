package com.wttechnologies.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("userDAO")
@Repository
public class UserDAO {

	// Properties
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	// Configured Basic DataSource from JDBC
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		getSession().save(user);
	}

	public boolean exists(String username) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT count(*) FROM users WHERE username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("Querying All users and their authorities");
		// return jdbc.query("SELECT * FROM users",
		// BeanPropertyRowMapper.newInstance(User.class));
		return getSession().createQuery("From User").list();

	}
}

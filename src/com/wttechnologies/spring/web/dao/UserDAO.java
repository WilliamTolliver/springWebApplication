package com.wttechnologies.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAO() {
		// TODO Auto-generated constructor stub
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
		Criteria crit = getSession().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		User user = (User) crit.uniqueResult();
		return user != null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("Querying All users and their authorities");
		// return jdbc.query("SELECT * FROM users",
		// BeanPropertyRowMapper.newInstance(User.class));
		return getSession().createQuery("From User").list();

	}
}

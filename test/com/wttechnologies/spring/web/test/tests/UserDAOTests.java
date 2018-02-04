package com.wttechnologies.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wttechnologies.spring.web.dao.User;
import com.wttechnologies.spring.web.dao.UserDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/wttechnologies/spring/web/config/dao-beans.xml",
		"classpath:com/wttechnologies/spring/web/config/security-context.xml",
		"classpath:com/wttechnologies/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTests {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DataSource dataSource;
	private Logger logger = Logger.getLogger(UserDAOTests.class);

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM offers");
		jdbc.execute("DELETE FROM users");
	}

	@Test
	public void testCreateUser() {
		User user = new User("Kevin", "KevinThompson", "Kevin123", "Kevin@gmail.com", true, "user");

		userDAO.create(user);

		List<User> users = userDAO.getAllUsers();

		assertEquals("Should return one user", 1, users.size());

		assertTrue("User should exist", userDAO.exists(user.getUsername()));

		assertEquals("User should equal user that is returned", user, users.get(0));
	}
}

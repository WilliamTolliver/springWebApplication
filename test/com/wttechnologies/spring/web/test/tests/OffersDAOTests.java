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

import com.wttechnologies.spring.web.dao.Offer;
import com.wttechnologies.spring.web.dao.OffersDAO;
import com.wttechnologies.spring.web.dao.User;
import com.wttechnologies.spring.web.dao.UserDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/wttechnologies/spring/web/config/dao-beans.xml",
		"classpath:com/wttechnologies/spring/web/config/security-context.xml",
		"classpath:com/wttechnologies/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDAOTests {

	@Autowired
	private OffersDAO offersDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DataSource dataSource;
	//private Logger logger = Logger.getLogger(OffersDAOTests.class);

	User user, user2;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM offers");
		jdbc.execute("DELETE FROM users");

		// Create users for offers
		user = new User("Kevin", "KevinPrime", "Kevin123", "Kevin@gmail.com", true, "ROLE_USER");

		userDAO.create(user);

		user2 = new User("William", "WilliamToll", "William123", "William@gmail.com", true, "ROLE_USER");

		userDAO.create(user2);
	}

	@Test
	public void testCreateOffer() {

		Offer offer = new Offer(user, "Kevin does FGC instruction");

		offersDAO.create(offer);
	}

	@Test
	public void TestGetUserOffers() {
		
		//Create offer 1
		Offer offer = new Offer(user, "Kevin does FGC instruction");
		offersDAO.create(offer);

		// Second offer
		Offer offer2 = new Offer(user, "This is another offer by Kevin for MMA training.");

		offersDAO.create(offer2);

		List<Offer> userOffers = offersDAO.getOffers(user.getUsername());

		assertEquals("Number of offers should match", 2, userOffers.size());
	}

	@Test
	public void testRetrieveManyOffers() {
		Offer offer = new Offer(user2, "Kevin does FGC instruction");

		offersDAO.create(offer);

		// Second offer
		Offer offer2 = new Offer(user, "This is another offer by Kevin for MMA training.");

		offersDAO.create(offer2);

		List<Offer> offers = offersDAO.getOffers();

		assertEquals("Should return one offer", 2, offers.size());

	}
}

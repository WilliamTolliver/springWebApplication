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

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/wttechnologies/spring/web/config/dao-beans.xml",
		"classpath:com/wttechnologies/spring/web/config/security-context.xml",
		"classpath:com/wttechnologies/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDAOTests {

	@Autowired
	private OffersDAO offersDAO;
	@Autowired
	private DataSource dataSource;
	private Logger logger = Logger.getLogger(OffersDAOTests.class);

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM offers");
	}

	@Test
	public void testCreateUser() {
		Offer offer = new Offer("Kevin", "Kevin@gmail.com", "Kevin does FGC instruction");

		assertTrue("User creation should return true", offersDAO.create(offer));

		List<Offer> offers = offersDAO.getOffers();

		assertEquals("Should return one user", 1, offers.size());

		assertEquals("User should equal user that is returned", offer, offers.get(0));
	}
}

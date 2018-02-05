package com.wttechnologies.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDAO")
@Repository
@Transactional
public class OffersDAO {

	// Properties
	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	private SessionFactory sessionFactory;

	public OffersDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully loaded OffersDAO");
	}

	// Configured Basic DataSource from JDBC
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		// properties
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));

		return crit.list();
	}

	public List<Offer> getOffers(String username) {

		// properties
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));

		return crit.list();

	}

	public Offer findOffer(int id) {

		// properties
		MapSqlParameterSource params = new MapSqlParameterSource();
		System.out.println(id);
		params.addValue("id", id);

		return jdbc.queryForObject(
				"Select * from offers, users where offers.username = users.username and users.enabled=true and id = :id",
				params, new OfferRowMapper());
	}

	public Offer findOffer(String username) {

		// properties
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbc.queryForObject(
				"Select * from offers, users where offers.username = users.username and users.enabled=true and id = :id",
				params, new OfferRowMapper());
	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT into offers (username, text) VALUES(:username, :text)", params);
	}

	public void saveOrUpdate(Offer offer) {
		getSession().save(offer);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("Delete from offers where id = :id", params) == 1;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}

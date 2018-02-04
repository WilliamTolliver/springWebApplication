package com.wttechnologies.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

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
public class OffersDAO {

	// Properties
	private NamedParameterJdbcTemplate jdbc;

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
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Sue");

		return jdbc.query(
				"Select * from offers, users where offers.username = users.username and users.enabled=true",
				params, new OfferRowMapper());
	}

	public List<Offer> getOffers(String username) {

		// properties
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Sue");

		return jdbc.query(
				"Select * from offers, users WHERE offers.username = users.username and users.enabled=true and offers.username = :username",
				new MapSqlParameterSource("username", username),new OfferRowMapper());
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

	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("INSERT into offers (username, text) VALUES(:username, :text)", params) == 1;

	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT into offers (username, text) VALUES(:username, :text)", params);
	}

	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("UPDATE offers set text=:text where id=:id", params) == 1;
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("Delete from offers where id = :id", params) == 1;
	}

}

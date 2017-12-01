package com.wttechnologies.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDAO")
public class OffersDAO {

	// Properties
	private NamedParameterJdbcTemplate jdbc;

	public OffersDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully loaded OffersDAO");
	}
	
	//Configured Basic DataSource from JDBC
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		// properties
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Sue");

		return jdbc.query("Select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				return offer;
			}

		});
	}

	public Offer findOffer(int id) {

		// properties
		MapSqlParameterSource params = new MapSqlParameterSource();
		System.out.println(id);
		params.addValue("id", id);

		return jdbc.queryForObject("Select * from offers where id = :id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				return offer;
			}

		});
	}

	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("INSERT into offers (name, text, email) VALUES(:name, :text, :email)", params) == 1;

	}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT into offers (name, text, email) VALUES(:name, :text, :email)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("Delete from offers where id = :id", params) == 1;
	}

}

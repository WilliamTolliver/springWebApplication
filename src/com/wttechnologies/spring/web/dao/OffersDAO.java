package com.wttechnologies.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private SessionFactory sessionFactory;

	public OffersDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("Successfully loaded OffersDAO");
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
		// TODO Auto-generated method stub
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.add(Restrictions.idEq(id));
		Offer offer = (Offer) crit.uniqueResult();
		return offer;
	}

	public Offer findOffer(String username) {

		// properties
		// TODO Auto-generated method stub
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.username", username));
		Offer offer = (Offer) crit.uniqueResult();
		return offer;

	}

	public void saveOrUpdate(Offer offer) {
		getSession().save(offer);
	}

	public boolean delete(int id) {
		Query query = getSession().createQuery("DELETE FROM Offer WHERE id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}

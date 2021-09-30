package com.wissen.wcart.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wissen.wcart.entity.Seller;

@Repository
public class SellerDAOImpl implements SellerDAO {
	
	//define field for EntityManager
	private EntityManager entityManager;

	@Autowired
	public SellerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public void createNewSeller(Seller newSeller) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(newSeller);
	}

	@Override
	public void deleteExistingSeller(int sellerId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query deleteQuery = currentSession.createQuery("delete from Seller where seller_id=:sellerId");
		deleteQuery.setParameter("sellerId", sellerId);
		deleteQuery.executeUpdate();
	}

	@Override
	public void updateExistingSeller(Seller updatedSeller) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(updatedSeller);
	}
	
	@Override
	public Seller findBySellerId(int sellerId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Seller seller = currentSession.get(Seller.class, sellerId);
		return seller;
	}

}

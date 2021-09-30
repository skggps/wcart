package com.wissen.wcart.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wissen.wcart.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//define field for EntityManager
	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void registerNewCustomer(Customer newCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(newCustomer);
	}

	@Override
	public void removeExistingCustomer(String loginId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query deleteQuery = currentSession.createQuery("delete from Customer where login_id=:loginId");
		deleteQuery.setParameter("loginId", loginId);
		deleteQuery.executeUpdate();
	}

	@Override
	public Customer findByLoginId(String loginId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customer = currentSession.get(Customer.class, loginId);
		return customer;
	}

}

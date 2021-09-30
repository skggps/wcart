package com.wissen.wcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.wcart.dao.CustomerDAO;
import com.wissen.wcart.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void registerNewCustomer(Customer newCustomer) {
		customerDAO.registerNewCustomer(newCustomer);
	}

	@Override
	@Transactional
	public void removeExistingCustomer(String loginId) {
		customerDAO.removeExistingCustomer(loginId);
	}

	@Override
	public Customer findByLoginId(String loginId) {
		return customerDAO.findByLoginId(loginId);
	}

}

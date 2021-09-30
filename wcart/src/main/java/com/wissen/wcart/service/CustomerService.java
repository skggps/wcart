package com.wissen.wcart.service;

import com.wissen.wcart.entity.Customer;

public interface CustomerService {
	
	public void registerNewCustomer(Customer newCustomer);
	
	public void removeExistingCustomer(String loginId);
	
	public Customer findByLoginId(String loginId);

}

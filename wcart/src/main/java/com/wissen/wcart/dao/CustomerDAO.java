package com.wissen.wcart.dao;

import com.wissen.wcart.entity.Customer;

public interface CustomerDAO {
	
	public void registerNewCustomer(Customer newCustomer);
	
	public void removeExistingCustomer(String loginId);
	
	public Customer findByLoginId(String loginId);

}

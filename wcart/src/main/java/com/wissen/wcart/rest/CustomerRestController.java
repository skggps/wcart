package com.wissen.wcart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.wcart.entity.Customer;
import com.wissen.wcart.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// Register new Customer - POST - "/register"
	@PostMapping("/register")
	public Customer register(@RequestBody Customer newCustomer)	{
		// If someone passes an id in JSON, set id to 0. This is to save a new item instead of update
		customerService.registerNewCustomer(newCustomer);
		return newCustomer;
	}
	
	
	// Delete an existing customer - DELETE - "/unRegister/{loginId}"
	@DeleteMapping("/unRegister/{loginId}")
	public String deRegister(@PathVariable String loginId) {

		Customer tempCustomer = customerService.findByLoginId(loginId);
		if (tempCustomer == null) {
			throw new RuntimeException("Mentioned UserId is not found - " + loginId);
		}

		customerService.removeExistingCustomer(loginId);
		return "Deleted user - " + loginId;
	}
	
	
	

}

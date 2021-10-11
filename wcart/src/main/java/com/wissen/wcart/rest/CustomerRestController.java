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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Customer Rest Controller", description = "REST APIs related to Customer")
//@ApiOperation(value = "/customer ", tags = "Customer Rest Controller")
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// Register new Customer - POST - "/register"
	@ApiOperation(value = "Register a new Customer ", response = Customer.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "Unauthorized"), 
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found") })
	@PostMapping("/register")
	public Customer register(@RequestBody Customer newCustomer)	{
		// If someone passes an id in JSON, set id to 0. This is to save a new item instead of update
		customerService.registerNewCustomer(newCustomer);
		return newCustomer;
	}
	
	
	// Delete an existing customer - DELETE - "/unRegister/{loginId}"
	@ApiOperation(value = "Delete an existing customer ", response = String.class)
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Unauthorized"), 
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping("/unRegister/{loginId}")
	public String unRegister(@PathVariable String loginId) {

		Customer tempCustomer = customerService.findByLoginId(loginId);
		if (tempCustomer == null) {
			throw new RuntimeException("Mentioned UserId is not found - " + loginId);
		}

		customerService.removeExistingCustomer(loginId);
		return "Deleted user - " + loginId;
	}
	
	
}

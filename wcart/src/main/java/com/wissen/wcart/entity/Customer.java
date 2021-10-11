package com.wissen.wcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	// field -> login Id, first name, last name, email, phone, address
	
	@Id
	@Column(name="login_id")
    @ApiModelProperty(name="loginId", notes = "Login Id of Customer", value = "10")
	private String loginId;
	
	@ApiModelProperty(name="firstName", notes = "First Name of Customer", required = true, value = "Steve")
	@Column(name="first_name")
	private String firstName;
	
	@ApiModelProperty(name="lastName", notes = "Last Name of Customer", required = true, value = "Smith")
	@Column(name="last_name")
	private String lastName;
	
	@ApiModelProperty(name="email", notes = "Email of Customer", required = true, value = "abc@gmail.com")
	@Column(name="email")
	@Email
	private String email;
	
	@ApiModelProperty(name="phoneNo", notes = "Phone no of Customer", required = true, value = "12345678")
	@Column(name="phone_no")
	private String phoneNo; 
	
	@ApiModelProperty(name="address", notes = "Address of Customer", required = true, value = "New Jersey, USA")
	@Column(name="address")
	private String address; // Later will use Address ref

	
	public Customer() {
		
	}

	public Customer(String loginId, String firstName, String lastName, String email, String phoneNo, String address) {
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [loginId=");
		builder.append(loginId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
}

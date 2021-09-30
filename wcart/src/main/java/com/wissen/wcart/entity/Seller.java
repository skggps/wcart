package com.wissen.wcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	
	// Seller name, email, phone numbers, address, seller rating (start as bronze, can increase it to silver, gold and platinum)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seller_id")
	private int sellerId;
	
	@Column(name="seller_name")
	private String sellerName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="rating")
	private String rating;

	
	public Seller() {
		
	}

	public Seller(String sellerName, String email, String phoneNo, String address, String rating) {
		this.sellerName = sellerName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.rating = rating;
	}


	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seller [sellerId=");
		builder.append(sellerId);
		builder.append(", sellerName=");
		builder.append(sellerName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append(", address=");
		builder.append(address);
		builder.append(", rating=");
		builder.append(rating);
		builder.append("]");
		return builder.toString();
	}

		
}

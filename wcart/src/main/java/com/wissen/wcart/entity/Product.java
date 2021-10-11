package com.wissen.wcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {
	
	//Product name, Description, Price and Category
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	@Size(min = 3, message = "Product Name should have atleast 3 characters")
	@NotNull
	private String productName;
	
	@Column(name="product_description")
	@Size(min = 3, message = "Product Description should have atleast 3 characters")
	@NotNull
	private String productDescription;
	
	@Column(name="price")
	@NotNull
	private Double price;
	
	@Column(name="product_category")
	@NotNull
	private String productCategory;

	public Product() {
		
	}

	public Product(String productName, String productDescription, Double price, String productCategory) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.productCategory = productCategory;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productDescription=");
		builder.append(productDescription);
		builder.append(", price=");
		builder.append(price);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append("]");
		return builder.toString();
	}
	
}

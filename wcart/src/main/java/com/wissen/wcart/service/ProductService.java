package com.wissen.wcart.service;

import java.util.List;

import com.wissen.wcart.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public List<Product> findByProductName(String productName);
	
	public Product findByProductId(int productId);
	
	public Product addNewProduct(Product newProduct);
	
	public void updateExistingProduct(Product product);
	
	public void deleteByProductId(int productId);

}

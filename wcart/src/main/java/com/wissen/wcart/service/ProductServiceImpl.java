package com.wissen.wcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.wcart.dao.ProductDAO;
import com.wissen.wcart.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	@Transactional
	public List<Product> findByProductName(String productName) {
		return productDAO.findByProductName(productName);
	}
	
	@Override
	@Transactional
	public Product findByProductId(int productId) {
		return productDAO.findByProductId(productId);
	}

	@Override
	@Transactional
	public Product addNewProduct(Product newProduct) {
		return productDAO.addNewProduct(newProduct);
	}

	@Override
	@Transactional
	public void updateExistingProduct(Product product) {
		productDAO.updateExistingProduct(product);
	}

	@Override
	@Transactional
	public void deleteByProductId(int productId) {
		productDAO.deleteByProductId(productId);
	}

}

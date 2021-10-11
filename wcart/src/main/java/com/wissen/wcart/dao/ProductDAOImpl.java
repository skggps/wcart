package com.wissen.wcart.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.wcart.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	//define field for EntityManager
	private EntityManager entityManager;
	
	@Autowired
	public ProductDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	// @Transactional
	public List<Product> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Product> productQuery = currentSession.createQuery("from Product", Product.class);
		
		// execute query and get result list
		List<Product> products = productQuery.getResultList();
		
		// return the result
		return products;
	}


	@Override
	public List<Product> findByProductName(String productName) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query searchQuery = currentSession.createQuery("from Product where product_name=:pName");
		searchQuery.setParameter("pName", productName);
		List<Product> products = searchQuery.list();
		return products;
	}
	
	@Override
	public Product findByProductId(int productId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product product = currentSession.get(Product.class, productId);
		return product;
	}


	@Override
	public Product addNewProduct(Product newProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(newProduct);
		return newProduct;
	}


	@Override
	public void updateExistingProduct(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
	}


	@Override
	public void deleteByProductId(int productId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query deleteQuery = currentSession.createQuery("delete from Product where product_id=:pId");
		deleteQuery.setParameter("pId", productId);
		deleteQuery.executeUpdate();
	}

}

















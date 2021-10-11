package com.wissen.wcart.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wissen.wcart.entity.Product;
import com.wissen.wcart.exception.ProductNotfoundException;
import com.wissen.wcart.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	private ProductService productService;
	
	// inject productService using CI
	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	
	
	// Fetch list of all products - GET - "/products" 
	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	// To find a product by productId - GET -> "/product/{productId}"
	// Implementing HATEOAS - return EntityModel object
	@GetMapping("/productId/{productId}")
	public Product getProductById(@PathVariable int productId) {
		
		Product product = productService.findByProductId(productId);
		if(product == null)
			throw new ProductNotfoundException("Product Id not found - " + productId);
		
		return product;
	}
	
	// To find a product by productName - GET -> "/product/{productName}"
	@GetMapping("/productName/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) {
		
		List<Product> products = productService.findByProductName(productName);
		return products;
	}
	
	// Add a new Product - POST - "/addProduct"
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product newProduct)	{
		// If someone passes an id in JSON, set id to 0. This is to save a new item instead of update
		newProduct.setProductId(0);
		Product product = productService.addNewProduct(newProduct);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(product.getProductId()).toUri();  
		return ResponseEntity.created(location).build();  
		//return newProduct;
	}
	
	// Update existing product - PUT - "/updateProduct"
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product updatedProduct) {
		productService.updateExistingProduct(updatedProduct);
		return updatedProduct;
	}
	
	// Delete an existing product - DELETE - "/product/{productId}"
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {

		Product tempProduct = productService.findByProductId(productId);
		// throw exception if null
		if (tempProduct == null) {
			//throw new RuntimeException("Product id not found - " + productId);
			throw new ProductNotfoundException("Product id not found - " + productId);
		}

		productService.deleteByProductId(productId);
		return "Deleted employee id - " + productId;
	}
	

}

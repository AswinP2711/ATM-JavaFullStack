package com.myspringmvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspringmvcproject.db.ProductDB;
import com.myspringmvcproject.model.Product;

@Component
public class ProductService {
	
	@Autowired
	private ProductDB productDb;
	
	public List<Product> getAllProducts() {
		return productDb.getAllProducts();
	}

	public void insertProduct(Product product) {
		productDb.insertProduct(product);
	}

	public void deleteProduct(int pid) {
		productDb.deleteProduct(pid);
		
	}

	public Product getProductById(int pid) {
		return productDb.getProductById(pid);
	}

	public void editProduct(Product product) {
		productDb.editProduct(product);
	}
	
}

package com.main.service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.db.ProductDB;
import com.main.model.Product;



public class ProductService {
	ProductDB productDB;
	
	public void insertProduct(Product p) {
		productDB=new ProductDB();
		productDB.insertProduct(p);
		productDB=null;
	}
	
	public List<Product> getAllProducts(){
		productDB=new ProductDB();
		List<Product> list= productDB.getAllProducts();
		productDB=null;
		return list;
		
		
	}

	public boolean validateId(int id) {
		productDB=new ProductDB();
		List<Product> list= productDB.getAllProducts();
		list=list.stream().filter(p->p.getId()==id).collect(Collectors.toList());
		if(list != null && list.size()==1) {
			return true;
		}else {
			return false;
		}
		
	}

	public void deleteProduct(int id) {
		productDB=new ProductDB();
		productDB.deleteProduct(id);
		productDB=null;
		
		
		
	}
	
	
	
}

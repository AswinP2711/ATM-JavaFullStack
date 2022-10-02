package com.main.service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.db.ProductDB;
import com.main.dto.ProductStatsDto;
import com.main.model.Product;

public class ProductService {
	ProductDB productDB;
	public List<Product> getAllProducts(){
		productDB=new ProductDB();
		 List<Product> list=productDB.getAllProducts();
		 productDB=null;
		 return list;
		 
	 }
	public void inesertProduct(Product p) {
		productDB=new ProductDB();
		productDB.insertProduct(p);
		productDB=null;
	}
	public boolean validateId(int id) {
		productDB=new ProductDB();
		List<Product> list=productDB.getAllProducts();
		list=list.stream().filter(p->p.getId()==id).collect(Collectors.toList());
		if (list!=null && list.size()==1) {
			return true;
		} else {
			return false;
		}
		
	}
	public void deleteProductById(int id) {
		productDB=new ProductDB();
		productDB.deleteProductById(id);
		productDB=null;
		
	}
	public void filterByProduct(String ven) {
		productDB=new ProductDB();
		List<Product> list=productDB.getAllProducts();
		list.parallelStream().filter(p->p.getVendor().equals(ven)).forEach(p->System.out.println(p));
		productDB=null;
		
	}
	public List<ProductStatsDto> fetchStats() {
		productDB=new ProductDB();
		List<ProductStatsDto> list=productDB.fetchStats();
		productDB=null;
		return list;
		
	}
}

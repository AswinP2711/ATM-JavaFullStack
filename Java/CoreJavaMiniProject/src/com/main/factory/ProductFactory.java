package com.main.factory;

import java.util.List;

import com.main.model.Product;
import com.main.service.ProductService;

public class ProductFactory {
	static ProductService productService =new ProductService();
	
	public static void getAllProducts() {
		List<Product> list=productService.getAllProducts();
		if(list != null) {
			
			for(Product p : list) {
				System.out.println(p);
			}
		}
	}
}

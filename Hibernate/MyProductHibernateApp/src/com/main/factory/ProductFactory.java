package com.main.factory;

import java.util.List;

import javax.persistence.EntityManager;

import com.main.model.Product;
import com.main.model.Review;
import com.main.model.Vendor;

public class ProductFactory {
	private ProductFactory() {

	}

	public static ProductFactory getInstance() {
		return new ProductFactory();
	}

	public List<Vendor> getAllVendors(EntityManager entityManager) {
		List<Vendor> list = entityManager.createQuery("select v from Vendor v", Vendor.class).getResultList();
		return list;
	}

	public List<Product> getAllProducts(EntityManager entityManager) {
		List<Product> list = entityManager.createQuery("select p from Product p", Product.class).getResultList();
		return list;
	}

	public List<Product> getProductsByVendorId(EntityManager entityManager, int vid) {
		List<Product> list = entityManager.createQuery("select p from Product p where p.vendor.id=:vid", Product.class)
				.setParameter("vid", vid).getResultList();
		return list;
	}

	public List<Review> getReviewsByProductId(EntityManager entityManager, int pid) {
		List<Review> list = entityManager.createQuery("select r from Review r where r.product.id=:pid", Review.class)
				.setParameter("pid", pid).getResultList();
		return list;
	}
}

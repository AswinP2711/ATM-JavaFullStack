package com.myspringmvcproject.model;

public class Product {
	private int id;
	private String title;
	private double price;
	private String vendor;
	
	public Product() {
		super();
	}
	
	public Product(int id, String title, double price, String vendor) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.vendor = vendor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", vendor=" + vendor + "]";
	}
}

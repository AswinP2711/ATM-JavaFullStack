package com.main.dto;

public class ProductStatsDto {
	private String vendor;
	private int num;
	public ProductStatsDto() {
		
	}
	public ProductStatsDto(String vendor, int num) {
		super();
		this.vendor = vendor;
		this.num = num;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "ProductStatsDto [vendor=" + vendor + ", number_of_products=" + num + "]";
	}	
}

package com.main.model;

public class Employee {
	private int id;
	private String name;
	private String city;
	private double Salary;
	
	public Employee() {
		super();
	}
	
	
	public Employee(int id, String name, String city, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		Salary = salary;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", Salary=" + Salary + "]";
	}
	
	
	
}

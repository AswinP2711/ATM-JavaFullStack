package com.myspringmvcproject.model;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String branch;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, double salary, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.branch = branch;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", branch=" + branch + "]";
	}
	
	
	
}

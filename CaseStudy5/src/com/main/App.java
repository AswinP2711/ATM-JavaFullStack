package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.main.model.Employee;
import com.main.utility.EmployeeSortUtility;

public class App {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Employee e1=new Employee(1, "Harry Potter", "London", 85000);
		Employee e2=new Employee(2, "Ronald Weasley", "Surrey", 75000);
		Employee e3=new Employee(3, "Hemoine Granger", "London", 95000);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		System.out.println("ASC Order");
		System.out.println();
		Collections.sort(list,new EmployeeSortUtility());
		list.stream().forEach(emp->System.out.println(emp));
		
		System.out.println();
		System.out.println("Employees having salary < 80000");
		System.out.println();
		list.parallelStream().filter(emp->emp.getSalary()<80000).forEach(emp->System.out.println(emp));
		
		System.out.println();
		System.out.println("Employees living in London");
		System.out.println();
		list.parallelStream().filter(emp->emp.getCity().equals("London")).forEach(emp->System.out.println(emp));
		
		

	}

}
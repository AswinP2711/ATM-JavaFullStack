package com.main.utility;

import java.util.Comparator;

import com.main.model.Employee;

public class EmployeeSortUtility implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return (int)(e2.getSalary()-e1.getSalary());
	}

}

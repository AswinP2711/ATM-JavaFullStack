package com.myspringmvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspringmvcproject.db.EmployeeDB;
import com.myspringmvcproject.model.Employee;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeDB employeeDb;

	public List<Employee> getAllEmployees() {
		return employeeDb.getAllEmployees();
	}

	public void insertEmployee(Employee employee) {
		employeeDb.insertEmployee(employee);
	}

}

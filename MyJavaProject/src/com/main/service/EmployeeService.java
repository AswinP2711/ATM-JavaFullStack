package com.main.service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.db.EmployeeDB;
import com.main.dto.EmployeeStatsDto;
import com.main.model.Employee;

public class EmployeeService {
	EmployeeDB employeeDB;
	public List<Employee> getAllEmployees(){
		employeeDB = new EmployeeDB();
		List<Employee> list= employeeDB.getAllEmployees();
		employeeDB=null;
				
		return list;
		
	}

	public void insertEmployee(Employee e) {
		employeeDB = new EmployeeDB();
		employeeDB.insertEmployee(e);
		employeeDB=null;
	}

	public void deleteEmployeeById(int id) {
		employeeDB = new EmployeeDB();
		employeeDB.deleteEmployee(id);
		employeeDB=null;
		
		
	}

	public boolean validateId(int id) {
		employeeDB = new EmployeeDB();
		List<Employee> list= employeeDB.getAllEmployees();
		list = list.stream()
				.filter(e->e.getId()==id)
				.collect(Collectors.toList());
		if(list != null && list.size()==1) {
			return true;
		}else {
			return false;
		}
		
	}

	public void filterByBranch(String branch) {
		employeeDB = new EmployeeDB();
		List<Employee> list= employeeDB.getAllEmployees();
		list.parallelStream()
		.filter(e->e.getBranch().equals(branch))
		.forEach(e->System.out.println(e));
		
	}

	public List<EmployeeStatsDto> fetchStats() {
		employeeDB = new EmployeeDB();
		List<EmployeeStatsDto> list = employeeDB.fetchStats();
		return list;
	}
}

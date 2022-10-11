package com.myspringmvcproject.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.myspringmvcproject.model.Employee;

@Component
public class EmployeeDB {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc=new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Employee> getAllEmployees() {
		String sql="select * from employee";
		return jdbc.query(sql, new B());
	}

	public void insertEmployee(Employee employee) {
		String sql="insert into employee(name,salary,branch) values(:name,:salary,:branch)";
		Map<String, Object> map = new HashMap<>();
		map.put("name", employee.getName());
		map.put("salary", employee.getSalary());
		map.put("branch", employee.getBranch());
		jdbc.update(sql, map);
	}

}

class B implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e= new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setSalary(rs.getDouble("salary"));
		e.setBranch(rs.getString("branch"));
		return e;
	}
	
}

package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.dto.EmployeeStatsDto;
import com.main.model.Employee;

public class EmployeeDB {

	private Connection con;
	
	public void dbConnect() {
		
		
		String url="jdbc:mysql://localhost:3306/mydb_2000078293";
		String username="root";
		String password="Password123";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void dbClose() {
		try {
			con.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees(){
		dbConnect();
		
		String sql="select * from employee";
		List<Employee> list = new ArrayList<>();
		
		try {
			PreparedStatement psmt= con.prepareStatement(sql);
			ResultSet rst=psmt.executeQuery();
			
			while(rst.next()) {
				Employee e=new Employee();
				e.setId(rst.getInt("id"));
				e.setName(rst.getString("name"));
				e.setSalary(rst.getDouble("salary"));
				e.setBranch(rst.getString("Branch"));
				
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		dbClose();
		return list;
	}


	public void insertEmployee(Employee e) {
		dbConnect();
		
		String sql="insert into employee(name,salary,branch) values(?,?,?)";
		
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, e.getName());
			psmt.setDouble(2, e.getSalary());
			psmt.setString(3, e.getBranch());
			
			psmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		dbClose();
		
		
	}


	public void deleteEmployee(int id) {
		dbConnect();
		
		String sql="delete from employee where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


	public List<EmployeeStatsDto> fetchStats() {
		dbConnect();
		
		String sql="select branch,COUNT(id) as number_of_employees from employee group by branch";
		List<EmployeeStatsDto> list=new ArrayList<>();
		
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			ResultSet rst=psmt.executeQuery();
			while(rst.next()) {
				EmployeeStatsDto dto=new EmployeeStatsDto();
				dto.setBranch(rst.getString("branch"));
				dto.setNum(rst.getInt("number_of_employees"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}

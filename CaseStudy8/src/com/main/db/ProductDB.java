package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.Product;

public class ProductDB {
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
	
	public void insertProduct(Product p) {
		dbConnect();
		
		String sql="insert into product(name,price,description) values(?,?,?)";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, p.getName());
			psmt.setDouble(2, p.getPrice());
			psmt.setString(3, p.getDescription());
			
			psmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}

		dbClose();
		
	}
	
	public List<Product> getAllProducts(){
		dbConnect();
		
		String sql="select * from product";
		List<Product> list = new ArrayList<>();
		
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rst=psmt.executeQuery();
			
			while(rst.next()) {
				Product p=new Product();
				p.setId(rst.getInt("id"));
				p.setName(rst.getString("name"));
				p.setPrice(rst.getDouble("price"));
				p.setDescription(rst.getString("description"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
		
	}

	public void deleteProduct(int id) {
		dbConnect();
		String sql="delete from product where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}
	
}

package com.main.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.dto.ProductStatsDto;
import com.main.model.Product;

public class ProductDB {
	private Connection con;
	
	private void dbConnect() {
		String url="jdbc:mysql://localhost:3306/mydb_2000078293";
		String username="root";
		String password="Password123";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		dbConnect();
		String sql="select * from productmini";
		List<Product> list =new ArrayList<>();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rst=psmt.executeQuery();
			while(rst.next()) {
				Product p=new Product();
				p.setId(rst.getInt("id"));
				p.setTitle(rst.getString("title"));
				p.setPrice(rst.getDouble("price"));
				p.setVendor(rst.getString("vendor"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
		
	}

	public void insertProduct(Product p) {
		dbConnect();
		String sql="insert into productmini(title,price,vendor) values(?,?,?)";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, p.getTitle());
			psmt.setDouble(2, p.getPrice());
			psmt.setString(3, p.getVendor());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}

	public void deleteProductById(int id) {
		dbConnect();
		String sql="delete from productmini where id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}

	public List<ProductStatsDto> fetchStats() {
		dbConnect();
		String sql="select vendor,count(id) as number_of_products from productmini group by vendor";
		List<ProductStatsDto> list=new ArrayList<>();
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			ResultSet rst=psmt.executeQuery();
			while(rst.next()) {
				ProductStatsDto dto=new ProductStatsDto();
				dto.setVendor(rst.getString("vendor"));
				dto.setNum(rst.getInt("number_of_products"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	

}


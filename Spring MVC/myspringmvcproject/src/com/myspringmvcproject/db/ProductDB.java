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

import com.myspringmvcproject.model.Product;

@Component
public class ProductDB {
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Product> getAllProducts() {
		String sql="select * from product1";
		return jdbc.query(sql, new A());
	}

	public void insertProduct(Product product) {
		String sql="insert into product1(title,price,vendor) values (:title,:price,:vendor)";
		Map<String,Object> map=new HashMap<>();
		map.put("title",product.getTitle());
		map.put("price", product.getPrice());
		map.put("vendor", product.getVendor());
		jdbc.update(sql, map);
	}

	public void deleteProduct(int pid) {
		String sql="delete from product1 where id=:id";
		Map<String, Integer> map = new HashMap<>();
		map.put("id", pid);
		jdbc.update(sql, map);
	}

	public Product getProductById(int pid) {
		String sql="select * from product1 where id=:id";
		Map<String,Integer> map=new HashMap<>();
		map.put("id",pid);
		return jdbc.queryForObject(sql, map, new A());
	}

	public void editProduct(Product product) {
		String sql="update product1 set title=:title,price=:price,vendor=:vendor where id=:id";
		Map<String,Object> map=new HashMap<>();
		map.put("id", product.getId());
		map.put("title",product.getTitle());
		map.put("price", product.getPrice());
		map.put("vendor", product.getVendor());
		jdbc.update(sql, map);
	}
}

class A implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setTitle(rs.getString("title"));
		p.setPrice(rs.getDouble("price"));
		p.setVendor(rs.getString("vendor"));
		return p;
	}
	
}
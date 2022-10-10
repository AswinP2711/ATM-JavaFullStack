package com.myspringmvcproject.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
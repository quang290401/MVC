package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.Product;

public class ProductMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet resultSet) {
		try {
			Product product = new Product();
			product.setNumOrDer(resultSet.getLong("NUMORDER"));
			product.setIdProduct(resultSet.getString("id"));
			product.setNameProduct(resultSet.getString("tenSanPham"));
			product.setPriceProduct(resultSet.getBigDecimal("giaSanPham"));
			product.setCategoryProduct(resultSet.getString("iddanhmuc"));
			product.setQuantity(resultSet.getInt("soLuong"));
			product.setStatus(resultSet.getInt("trangThai"));
			return product;
		} catch (SQLException e) {
			return null;
		}
	}
	
}

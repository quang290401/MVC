package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.ItemCart;


public class ItemCartMapper implements RowMapper<ItemCart> {

	@Override
	public ItemCart mapRow(ResultSet resultSet) {
		
		try {
			ItemCart itemCart = new ItemCart();
			itemCart.setIdGiohang(resultSet.getString("idGioHang"));
			itemCart.setIdSanPham(resultSet.getString("idSanPham"));
			itemCart.setSoLuongMua(resultSet.getInt("soLuong"));
			itemCart.setNumOrDer(resultSet.getLong("NUMORDER"));
			itemCart.setIdProduct(resultSet.getString("id"));
			itemCart.setNameProduct(resultSet.getString("tenSanPham"));
			itemCart.setPriceProduct(resultSet.getBigDecimal("giaSanPham"));
			itemCart.setCategoryProduct(resultSet.getString("iddanhmuc"));
			itemCart.setQuantity(resultSet.getInt("soLuong"));
			itemCart.setStatus(resultSet.getInt("trangThai"));
			itemCart.setImage(resultSet.getString("img"));
			return itemCart;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return null;
	
	}

}

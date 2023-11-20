package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.Cart;



public class CartMapper implements  RowMapper<Cart>  {

	@Override
	public Cart mapRow(ResultSet rs) {
		try {
			Cart cart = new Cart();
			cart.setNumOrDer(rs.getInt("Numorder"));
			cart.setId(rs.getString("id"));
			cart.setIdUser(rs.getString("idKhachhang"));
			cart.setNgayTao(rs.getDate("ngaytao"));
			
			return cart;
		} catch (SQLException e) {
			return null;
		}
	}

}

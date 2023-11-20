package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.DetailCart;


public class DetailCartmapper implements RowMapper<DetailCart>  {

	@Override
	public DetailCart mapRow(ResultSet rs) {
		try {
			DetailCart detailCart = new DetailCart();
			detailCart.setIdGioHang(rs.getString("idGioHang"));
			detailCart.setIdSanPham(rs.getString("idSanPham"));
			detailCart.setSoLuong(rs.getInt("soLuong"));
			
			return detailCart;
		} catch (SQLException e) {
			return null;
		}
	}
	

}

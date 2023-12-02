package com.DAO.IMPL;

import java.io.Serializable;
import java.util.List;

import com.DAO.ConnectionSQL;
import com.DAO.IdetailCartDAO;
import com.DAO.Model.Cart;
import com.DAO.Model.DetailCart;

import com.Mapper.CartMapper;



public class DetailCartDAO extends ConnectionSQL<DetailCart> implements IdetailCartDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public void save(DetailCart detailCart) {
		String sql = "insert into gioHangChiTiet (idGiohang, idSanpham, soLuong) values (?, ?, ?)";

		 insertCart(sql, detailCart.getIdGioHang(), detailCart.getIdSanPham(), detailCart.getSoLuong());
	}

	@Override
	public Cart findOneCart(String idUser) {
		String sql = "select *from gioHang where idKhachHang=?";
		List<Cart> caList = query(sql, new CartMapper(), idUser);
		return caList.isEmpty() ? null : caList.get(0);
	}

	@Override
	public void delete(String id) {
		String sql = "delete from gioHangChiTiet where idSanPham=?";
		update(sql, id);
		
	}

	@Override
	public void update2(int soluong,String idGioHang, String idSp) {
      String sql = "update gioHangChitiet set soLuong = soLuong+? where idGioHang like ? and idSanPham like ?";
		update(sql,soluong,idGioHang,idSp);
	}

}

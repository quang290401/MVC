package com.DAO.IMPL;

import java.util.List;

import com.DAO.ConnectionSQL;
import com.DAO.IItemCartDAO;
import com.DAO.Model.ItemCart;
import com.Mapper.ItemCartMapper;



public class ItemCartDAO extends ConnectionSQL<ItemCart> implements IItemCartDAO {

	@Override
	public List<ItemCart> findAllProduct(String idgioHang) {
		String sql = "select *from gioHangChitiet c,sanPham s where c.idgioHang LIKE ? and s.id=c.idSanPham";
		return query(sql, new ItemCartMapper(), idgioHang);
	}

}

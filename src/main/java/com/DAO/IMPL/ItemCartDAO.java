package com.DAO.IMPL;

import java.util.List;

import com.DAO.ConnectionSQL;
import com.DAO.IItemCartDAO;
import com.DAO.Model.ItemCart;
import com.DAO.Model.Product;
import com.Mapper.ItemCartMapper;
import com.Mapper.ProductMapper;


public class ItemCartDAO extends ConnectionSQL<ItemCart> implements IItemCartDAO {

	@Override
	public List<ItemCart> findAllProduct(String idgioHang) {
		String sql = "select *from gioHangChitiet c,sanPham s where c.idgioHang LIKE ? and s.id=c.idSanPham";
		return query(sql, new ItemCartMapper(), idgioHang);
	}

	@Override
	public ItemCart findOne(String idGioHang,String idSanPham) {
		String sql="select *from gioHangChitiet c,sanPham s where  c.idgioHang LIKE ? and s.id=c.idSanPham and idSanPham like ?";
		List<ItemCart> itemCarts = query(sql, new ItemCartMapper(), idGioHang,idSanPham);
		return itemCarts.isEmpty() ? null : itemCarts.get(0);
	}


}

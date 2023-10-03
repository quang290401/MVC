package com.DAO.IMPL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.ConnectionSQL;
import com.DAO.IproductDAO;
import com.DAO.Model.Product;
import com.Mapper.ProductMapper;
import com.paging.Pageble;

@SessionScoped
public class ProductDAO extends ConnectionSQL<Product> implements IproductDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Product> findAll(Pageble page) {
		String sql = "SELECT *FROM sanPham ORDER BY (SELECT NULL)OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return query(sql, new ProductMapper(),page.getOffset(),page.getlimit());
	}

	@Override
	public Product findOne(Long id) {
		String sql = "SELECT * FROM sanPham WHERE NUMORDER = ?";
		List<Product> product = query(sql, new ProductMapper(), id);
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public Long save(Product product) {
		String sql ="insert into SanPham (tensanPham,giaSanPham,idDanhMuc,soLuong,trangThai) values(?,?,?,?,?)";
		return insert(sql,product.getNameProduct(),product.getPriceProduct(),product.getCategoryProduct(),product.getQuantity(),product.getStatus());
	}

	@Override
	public void update(Product product) {
		StringBuilder sql = new StringBuilder("UPDATE sanPham SET tenSanPham = ?, giaSanpham = ?,");
		sql.append(" idDanhMuc = ?, soLuong = ?, trangThai = ?");
		sql.append(" where NUMORDER = ?");
		update(sql.toString(), product.getNameProduct(), product.getPriceProduct(), product.getCategoryProduct(),
				product.getQuantity(), product.getStatus(), product.getNumOrDer());
				
	}

	@Override
	public void delete(long ids) {
		String sql ="Delete from sanPham where numorder =?";
		update(sql,ids);
		
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM sanPham;";
		return count(sql);
	}
	

}

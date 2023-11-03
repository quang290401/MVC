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
import com.Mapper.CatagoryMapper;
import com.Mapper.ProductMapper;
import com.paging.Pageble;


public class ProductDAO extends ConnectionSQL<Product> implements IproductDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Product> findAll(Pageble page) {
		String sql = "SELECT *\r\n"
				+ "FROM sanPham\r\n"
				+ "ORDER BY ID DESC\r\n"
				+ "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
		return query(sql, new ProductMapper(), page.getOffset(), page.getlimit());
	}

	@Override
	public Product findOne(String  id) {
		String sql = "SELECT * FROM sanPham WHERE id = ?";
		List<Product> product = query(sql, new ProductMapper(), id);
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public String save(Product product) {
		String sql = "insert into SanPham (tensanPham,giaSanPham,idDanhMuc,soLuong,trangThai,img) values(?,?,?,?,?,?)";
		return insert(sql, product.getNameProduct(), product.getPriceProduct(), product.getCategoryProduct(),
				product.getQuantity(), product.getStatus(),product.getImage());
	}

	@Override
	public void update(Product product) {
		StringBuilder sql = new StringBuilder("UPDATE sanPham SET tenSanPham = ?, giaSanpham = ?,");
		sql.append(" idDanhMuc = ?, soLuong = ?, trangThai = ?,img = ?");
		sql.append(" where id = ?");
		update(sql.toString(), product.getNameProduct(), product.getPriceProduct(), product.getCategoryProduct(),
				product.getQuantity(), product.getStatus(),product.getImage(), product.getIdProduct());

	}

	@Override
	public void delete(long ids) {
		String sql = "Delete from sanPham where numorder =?";
		update(sql, ids);

	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM sanPham;";
		return count(sql);
	}

	@Override
	public List<Product> findAllProduct() {
		String sql = "SELECT * FROM sanpham";
		return query(sql, new ProductMapper());
	}

	@Override
	public Product findAllTopProduct() {
		String sql = "SELECT top(1)*FROM sanPham order by NUMORDER Desc";
		return query2(sql, new ProductMapper());
	}

	@Override
	public List<Product> findAllProductCatagory(String idcatagory) {
		String sql = "SELECT * FROM sanpham where iddanhmuc=?";
		return query(sql, new ProductMapper(), idcatagory);
	}

	@Override
	public Product findOne2(String id) {
		String sql = "SELECT * FROM sanPham WHERE id = ?";
		List<Product> product = query(sql, new ProductMapper(), id);
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public List<Product> findTop4() {
		// TODO Auto-generated method stub
		String sql = "SELECT TOP 4 *FROM sanPham ORDER BY NUMORDER DESC";
		return query(sql, new ProductMapper());
	}

}

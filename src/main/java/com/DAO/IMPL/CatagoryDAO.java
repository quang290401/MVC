package com.DAO.IMPL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.ConnectionSQL;
import com.DAO.IcatagoryDAO;
import com.DAO.Model.Catagory;
import com.Mapper.CatagoryMapper;

@SessionScoped
public class CatagoryDAO extends ConnectionSQL<Catagory> implements IcatagoryDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Catagory> findAll() {
		String sql = "SELECT * FROM danhMuc";
		return query(sql, new CatagoryMapper());
	}

	@Override
	public List<Catagory> findOne(String id) {
		String sql = "SELECT * FROM danhMuc WHERE id = ?";
		return query(sql, new CatagoryMapper(),id);
	}

}

package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.Catagory;


public class CatagoryMapper implements RowMapper<Catagory> {
	@Override
	public Catagory mapRow(ResultSet resultSet) {
		try {
			Catagory catagory = new Catagory();
			catagory.setIdCatagory(resultSet.getString("id"));
			catagory.setNameCatagory(resultSet.getString("tenDanhMuc"));
			
			return catagory;
		} catch (SQLException e) {
			return null;
		}
	}
}

package com.DAO.IMPL;

import java.util.List;

import com.DAO.ConnectionSQL;
import com.DAO.IuserDAO;
import com.DAO.Model.Product;
import com.DAO.Model.User;
import com.Mapper.CatagoryMapper;
import com.Mapper.ProductMapper;

public class UserDao extends ConnectionSQL<User> implements IuserDAO{

	@Override
	public User findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		String sql = "SELECT * FROM Users WHERE taiKhoan = ? and matKhau=? and status =?";
//		List<User> users = query(sql, new ProductMapper(), id);
//		return product.isEmpty() ? null : product.get(0);
		return null;
	}

}

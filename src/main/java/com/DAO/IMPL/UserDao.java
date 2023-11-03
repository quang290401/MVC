package com.DAO.IMPL;



import java.util.List;

import com.DAO.ConnectionSQL;
import com.DAO.IuserDAO;
import com.DAO.Model.User;
import com.Mapper.UserMapper;


public class UserDao extends ConnectionSQL<User> implements IuserDAO{

	@Override
	public User findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		StringBuilder sql=new StringBuilder( "SELECT * FROM Users AS u inner join vaitro AS v on u.numorder = v.numorder ") ;
		sql.append("WHERE taiKhoan LIKE  ? and matKhau LIKE  ? and status =?");
		List<User> users = query(sql.toString(), new UserMapper(),userName,passWord,status);
		return users.isEmpty() ? null : users.get(0);
		
	}

}

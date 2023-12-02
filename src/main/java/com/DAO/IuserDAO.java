package com.DAO;

import com.DAO.Model.DetailCart;
import com.DAO.Model.User;

public interface IuserDAO extends GenericDAO<User>{
	User findByUserNameAndPassWordAndStatus(String userName,String passWord,Integer status);
	void save(User user);

}

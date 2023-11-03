package com.service.IMPL;

import javax.inject.Inject;

import com.DAO.IuserDAO;
import com.DAO.Model.User;
import com.service.IuserService;

public class UserService implements IuserService  {
	@Inject
	private IuserDAO iuserDAO;

	@Override
	public User findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		
		return iuserDAO.findByUserNameAndPassWordAndStatus(userName, passWord, status);
	}

}

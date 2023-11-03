package com.service;

import com.DAO.Model.User;

public interface IuserService {
	User findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status);
}

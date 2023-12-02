package com.service;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Cart;
import com.DAO.Model.DetailCart;


@SessionScoped
public interface IdetailCartService  {
	
	void save(DetailCart detailCart);
	void delete(String id);

	void update2(int soLuong,String idGioHang,String idSP);
	 Cart findOneCart(String idUser);

}

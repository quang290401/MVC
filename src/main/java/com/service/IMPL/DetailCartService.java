package com.service.IMPL;



import java.io.Serializable;

import javax.inject.Inject;


import com.DAO.IdetailCartDAO;
import com.DAO.Model.Cart;
import com.DAO.Model.DetailCart;

import com.service.IdetailCartService;

public class DetailCartService implements IdetailCartService,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IdetailCartDAO dIdetailCartDAO;
	
	


	@Override
	public void save(DetailCart detailCart) {
		
		dIdetailCartDAO.save(detailCart);
	}

	@Override
	public Cart findOneCart(String idUser) {
		// TODO Auto-generated method stub
		return dIdetailCartDAO.findOneCart(idUser);
	}

	@Override
	public void delete(String id) {
		dIdetailCartDAO.delete(id);
		
	}

}

package com.service.IMPL;

import java.io.Serializable;
import java.util.List;


import javax.inject.Inject;

import com.DAO.IItemCartDAO;
import com.DAO.Model.ItemCart;
import com.service.IItemCartService;

public class ItemCartService implements IItemCartService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IItemCartDAO cartDAO;

	@Override
	public List<ItemCart> findAllProduct(String idgioHang) {
		// TODO Auto-generated method stub
		return cartDAO.findAllProduct(idgioHang);
	}

}

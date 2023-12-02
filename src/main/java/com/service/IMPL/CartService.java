package com.service.IMPL;

import com.DAO.IMPL.CartDAO;
import com.DAO.IcartDAO;
import com.DAO.Model.Cart;
import com.DAO.Model.User;
import com.service.IcartService;

import javax.inject.Inject;

public class CartService implements IcartService {
    @Inject
    CartDAO cartDAO;


    @Override
    public void save(String id, String ngayTao) {
        cartDAO.save(id,ngayTao);
    }
}

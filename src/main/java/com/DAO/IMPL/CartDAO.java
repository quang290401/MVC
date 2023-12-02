package com.DAO.IMPL;

import com.DAO.ConnectionSQL;
import com.DAO.IcartDAO;
import com.DAO.IcatagoryDAO;
import com.DAO.Model.Cart;
import com.DAO.Model.Catagory;

import java.io.Serializable;

public class CartDAO  extends ConnectionSQL<Cart> implements IcartDAO, Serializable {

    @Override
    public void save(String id,String ngayTao) {
        String sql="insert into giohang  VALUES(?,?)";
        insertCart(sql,id,ngayTao);
    }
}

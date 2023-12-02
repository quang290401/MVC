package com.service;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.ItemCart;
@SessionScoped
public interface IItemCartService {
	List<ItemCart> findAllProduct(String idgioHang );
	ItemCart finOne (String idGioHang,String idSanPham);
}

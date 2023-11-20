package com.DAO;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.ItemCart;
@SessionScoped
public interface IItemCartDAO extends GenericDAO<ItemCart>{
	List<ItemCart> findAllProduct(String idgioHang );
}

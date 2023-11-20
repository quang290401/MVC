package com.DAO;



import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Cart;
import com.DAO.Model.DetailCart;




@SessionScoped
public interface IdetailCartDAO {
	
	 void save(DetailCart detailCart);
	 void delete(String id);
	 Cart findOneCart(String idUser);
}

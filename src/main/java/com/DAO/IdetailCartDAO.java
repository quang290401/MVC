package com.DAO;



import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Cart;
import com.DAO.Model.DetailCart;




@SessionScoped
public interface IdetailCartDAO extends  GenericDAO<DetailCart>{
	
	 void save(DetailCart detailCart);
	 void delete(String id);
	  void   update2 (int soluong,String idGioHang,String idSp);
	 Cart findOneCart(String idUser);
}

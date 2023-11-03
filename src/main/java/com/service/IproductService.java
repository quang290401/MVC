package com.service;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Product;
import com.paging.Pageble;

@SessionScoped
public interface IproductService {
	List<Product> findAll(Pageble page);
	List<Product> findAllProduct();
	List<Product> findAllProductCatagory(String idcatagory);
	public Product findAllTopProduct() ;
	Product save (Product product);
	Product Update (Product product);
	void delete(long[] ids);
	Integer getTotalitem();
	Product finOne(String id);
	Product finOne2(String id);
    List< Product >findTop4();
	
}

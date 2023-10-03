package com.service;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Product;
import com.paging.Pageble;

@SessionScoped
public interface IproductService {
	List<Product> findAll(Pageble page);
	Product save (Product product);
	Product Update (Product product);
	void delete(long[] ids);
	Integer getTotalitem();
	
}

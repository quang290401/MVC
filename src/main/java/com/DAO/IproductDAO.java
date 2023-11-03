package com.DAO;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Product;
import com.paging.Pageble;

@SessionScoped
public interface IproductDAO extends GenericDAO<Product> {
	List<Product> findAll(Pageble page);
	List<Product> findAllProduct();
	List<Product> findAllProductCatagory(String idcatagory);
    Product findAllTopProduct();
	Product findOne(String id);
	String save(Product product);
	void update(Product product);
	void delete(long ids);
	int getTotalItem();
	Product findOne2(String id);
	List<Product> findTop4();

}

package com.DAO;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Product;
import com.paging.Pageble;

@SessionScoped
public interface IproductDAO extends GenericDAO<Product> {
	List<Product> findAll(Pageble page);
	Product findOne(Long id);
	Long save(Product product);
	void update(Product product);
	void delete(long ids);
	int getTotalItem();

}

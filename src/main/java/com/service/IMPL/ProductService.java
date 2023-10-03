package com.service.IMPL;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.service.IproductService;
import com.DAO.IproductDAO;
import com.DAO.Model.Product;
import com.paging.Pageble;
@SessionScoped
public class ProductService implements IproductService , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IproductDAO productdao;

	@Override
	public List<Product> findAll(Pageble page) {
		return productdao.findAll(page);
	}

	@Override
	public Product save(Product product) {
	 Long newid = productdao.save(product);
	return productdao.findOne(newid);
	}

	@Override
	public Product Update(Product product) {
		productdao.update(product);
		return productdao.findOne(product.getNumOrDer());
	}

	@Override
	public void delete(long[] ids) {
		for(long id :ids) {
			productdao.delete(id);
		}
		
	}

	@Override
	public Integer getTotalitem() {
		
		return productdao.getTotalItem();
	}

}

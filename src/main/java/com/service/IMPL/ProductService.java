package com.service.IMPL;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.service.IproductService;
import com.DAO.IcatagoryDAO;
import com.DAO.IproductDAO;
import com.DAO.Model.Catagory;
import com.DAO.Model.Product;
import com.paging.Pageble;

@SessionScoped
public class ProductService implements IproductService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IproductDAO productdao;
	
	@Inject
	private IcatagoryDAO caIcatagoryDAO;

	@Override
	public List<Product> findAll(Pageble page) {
		return productdao.findAll(page);
	}

	@Override
	public Product save(Product product) {
		Catagory catagory = caIcatagoryDAO.findOne2(product.getCategoryProduct());
		product.setCategoryProduct(catagory.getIdCatagory());
		String newid = productdao.save(product);
		return productdao.findOne(newid);
	}

	@Override
	public Product Update(Product product) {
		Catagory catagory = caIcatagoryDAO.findOne2(product.getCategoryProduct());
		product.setCategoryProduct(catagory.getIdCatagory());
		productdao.update(product);
		return productdao.findOne(product.getIdProduct());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			productdao.delete(id);
		}

	}

	@Override
	public Integer getTotalitem() {

		return productdao.getTotalItem();
	}

	@Override
	public List<Product> findAllProduct() {
		return productdao.findAllProduct();
	}

	@Override
	public Product findAllTopProduct() {
		// TODO Auto-generated method stub
		return productdao.findAllTopProduct();
	}

	@Override
	public List<Product> findAllProductCatagory(String idcatagory) {
		// TODO Auto-generated method stub
		return productdao.findAllProductCatagory(idcatagory);
	}

	@Override
	public Product finOne(String id) {
		// TODO Auto-generated method stub
		return productdao.findOne(id);
	}

	@Override
	public Product finOne2(String id) {
		Product product =  productdao.findOne2(id);
		return product;
	}

	@Override
	public List< Product> findTop4() {
		
		return productdao.findTop4();
	}

	
	

}

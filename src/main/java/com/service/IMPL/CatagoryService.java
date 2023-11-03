package com.service.IMPL;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.DAO.IcatagoryDAO;
import com.DAO.IMPL.ProductDAO;
import com.DAO.Model.Catagory;
import com.DAO.Model.Product;
import com.service.Icatagoryservice;

@SessionScoped
public class CatagoryService implements Icatagoryservice ,Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private IcatagoryDAO caIcatagoryDAO;
	
	@Inject
	private ProductDAO productDAO;

	@Override
	public List<Catagory> findAll() {
		return  caIcatagoryDAO.findAll();
	}

	@Override
	public List<Catagory> findOne(String id) {
		return caIcatagoryDAO.findOne(id);
	}

	
}

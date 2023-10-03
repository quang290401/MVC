package com.DAO;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Catagory;

@SessionScoped
public interface IcatagoryDAO extends GenericDAO<Catagory> {
	List<Catagory> findAll();
	List<Catagory> findOne(String id);
	
}

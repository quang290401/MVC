package com.service;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import com.DAO.Model.Catagory;

@SessionScoped
public interface Icatagoryservice {
	List<Catagory> findAll();
	List<Catagory> findOne(String id);

}

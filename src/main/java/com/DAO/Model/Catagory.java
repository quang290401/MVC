package com.DAO.Model;

public class Catagory extends AbstractModel<Catagory> {
	private String idCatagory;
	private String nameCatagory;

	public Catagory(String idCatagory, String nameCatagory) {
		super();
		this.idCatagory = idCatagory;
		this.nameCatagory = nameCatagory;
	}

	public Catagory() {
		super();
	}

	public String getIdCatagory() {
		return idCatagory;
	}

	public void setIdCatagory(String idCatagory) {
		this.idCatagory = idCatagory;
	}

	public String getNameCatagory() {
		return nameCatagory;
	}

	public void setNameCatagory(String nameCatagory) {
		this.nameCatagory = nameCatagory;
	}
 }

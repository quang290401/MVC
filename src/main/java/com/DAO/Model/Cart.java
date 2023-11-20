package com.DAO.Model;

import java.sql.Date;


public class Cart {
	private Integer numOrDer;
	private String id;
	private String idUser;
	private Date ngayTao;
	public Cart(Integer numOrDer, String id, String idUser, Date ngayTao) {
		super();
		this.numOrDer = numOrDer;
		this.id = id;
		this.idUser = idUser;
		this.ngayTao = ngayTao;
	}
	public Cart() {
		super();
	}
	public Integer getNumOrDer() {
		return numOrDer;
	}
	public void setNumOrDer(Integer numOrDer) {
		this.numOrDer = numOrDer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date date) {
		this.ngayTao = date;
	}

	
}

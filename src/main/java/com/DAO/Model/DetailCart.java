package com.DAO.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailCart {
	@JsonProperty("gioHang")
	private String idGioHang;
	@JsonProperty("sanPham")
	private String idSanPham;
	@JsonProperty("soLuong")
	private int soLuong;

	public DetailCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailCart(String idGioHang, String idSanPham, int soLuong) {
		super();
		this.idGioHang = idGioHang;
		this.idSanPham = idSanPham;
		
		this.soLuong = soLuong;
	}

	public String getIdGioHang() {
		return idGioHang;
	}

	public void setIdGioHang(String idGioHang) {
		this.idGioHang = idGioHang;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}



	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}

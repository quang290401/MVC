package com.DAO.Model;

import java.math.BigDecimal;

public class ItemCart {
	private String idGiohang;
	private String idSanPham;
	private int soLuongMua;

	private Long numOrDer;
	private String idProduct;
	private String nameProduct;
	private BigDecimal priceProduct;
	private String categoryProduct;
	private int quantity;
	private int status;
	private String image;

	public ItemCart(String idGiohang, String idSanPham, int soLuongMua, Long numOrDer, String idProduct,
			String nameProduct, BigDecimal priceProduct, String categoryProduct, int quantity, int status,
			String image) {
		super();
		this.idGiohang = idGiohang;
		this.idSanPham = idSanPham;
		this.soLuongMua = soLuongMua;
		this.numOrDer = numOrDer;
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.categoryProduct = categoryProduct;
		this.quantity = quantity;
		this.status = status;
		this.image = image;
	}

	public ItemCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdGiohang() {
		return idGiohang;
	}

	public void setIdGiohang(String idGiohang) {
		this.idGiohang = idGiohang;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public Long getNumOrDer() {
		return numOrDer;
	}

	public void setNumOrDer(Long numOrDer) {
		this.numOrDer = numOrDer;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public BigDecimal getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(BigDecimal priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(String categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

package com.DAO.Model;

import java.math.BigDecimal;

public class Product extends AbstractModel<Product> {
	private Long numOrDer;
	private String idProduct;
	private String nameProduct;
	private BigDecimal priceProduct;
	private String categoryProduct;
	private int quantity;
	private int status;
	private long ids[];

	public Product() {
		super();
	}

	public Product(Long numOrDer, String idProduct, String nameProduct, BigDecimal priceProduct, String categoryProduct,
			int quantity, int status) {
		super();
		this.numOrDer = numOrDer;
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.categoryProduct = categoryProduct;
		this.quantity = quantity;
		this.status = status;
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

	public long[] getIds() {
		return ids;
	}

	public void setIds(long ids[]) {
		this.ids = ids;
	}
	

	
}

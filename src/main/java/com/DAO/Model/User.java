package com.DAO.Model;

public class User extends AbstractModel<User> {
	private Long numOrDer;
	private String idUser;
	private String taiKhoan;
	private String matKhau;
	private String vaiTro;
	private Integer status;

	public String getVaiTro() {
		return vaiTro;
	}

	public Long getNumOrDer() {
		return numOrDer;
	}

	public void setNumOrDer(Long numOrDer) {
		this.numOrDer = numOrDer;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}

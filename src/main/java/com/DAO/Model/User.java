package com.DAO.Model;

import lombok.Getter;

@Getter
public class User extends AbstractModel<User> {
	private Long numOrDer;
	private String idUser;
	private String taiKhoan;
	private String matKhau;
	private String fullName;
	private Integer vaTroId;
	private Integer status;
	private Role role = new Role();

	

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getVaTroId() {
		return vaTroId;
	}

	public void setVaTroId(Integer vaTroId) {
		this.vaTroId = vaTroId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

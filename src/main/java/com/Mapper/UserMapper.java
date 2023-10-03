package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		User user = new User();
		try {
			user.setNumOrDer(rs.getLong("NumOrder"));
			user.setTaiKhoan(rs.getString("taikhoan"));
			user.setMatKhau(rs.getString("matkhau"));
			user.setVaiTro(rs.getString("vaitro"));
			user.setStatus(rs.getInt("status"));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

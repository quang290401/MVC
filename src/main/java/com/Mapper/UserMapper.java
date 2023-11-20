package com.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.Model.Role;
import com.DAO.Model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		User user = new User();
		try {
			user.setNumOrDer(rs.getLong("NumOrder"));
			user.setIdUser(rs.getString("id"));
			user.setTaiKhoan(rs.getString("taikhoan"));
			user.setMatKhau(rs.getString("matkhau"));
			user.setFullName(rs.getString("tennguoidung"));
			user.setVaTroId(rs.getInt("vaitroid"));
			user.setStatus(rs.getInt("status"));
			try {
				Role role = new Role();
				role.setTenVaiTro(rs.getString("tenvaitro"));
				role.setVaiTroId(rs.getInt("vaitroId"));
				user.setRole(role);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

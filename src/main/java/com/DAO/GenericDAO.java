package com.DAO;


import java.util.List;

import com.DAO.Model.Product;
import com.Mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	Product query2(String sql, RowMapper<Product> rowMapper, Object... parameters);
	void update (String sql, Object... parameters);
	String insert (String sql, Object... parameters);
	void insertCart (String sql, Object... parameters);

	int count(String sql, Object... parameters);
}

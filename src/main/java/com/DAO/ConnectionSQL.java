package com.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.DAO.Model.Cart;
import com.DAO.Model.Product;
import com.Mapper.RowMapper;


public class ConnectionSQL<T> implements GenericDAO<T> {
	static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public static Connection GetConnection() {
		String sql =resourceBundle.getString("sql");

		try {
			Class.forName(resourceBundle.getString("classforname"));
			return DriverManager.getConnection(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;

	}

	public static void closeJDBC(Connection cone, PreparedStatement stm, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {

			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException ex) {

			}
		}
		if (cone != null) {
			try {
				cone.close();
			} catch (SQLException ex) {

			}
		}
	}
	
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = GetConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				closeJDBC(connection, statement, resultSet);
			} catch (Exception e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if(parameter instanceof BigDecimal) {
					statement.setBigDecimal(index, (BigDecimal)parameter);
				} else if(parameter == null) {
					statement.setNull(index,Types.NULL);
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = GetConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
			closeJDBC(connection, statement, null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public String insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String id = null;
			connection = GetConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getString(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
			closeJDBC(connection, statement, resultSet);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = GetConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				closeJDBC(connection, statement, resultSet);
			} catch (Exception e) {
				return 0;
			}
		}
	}

	@Override
	public Product query2(String sql, RowMapper<Product> rowMapper, Object... parameters) {
	    Product result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        connection = GetConnection();
	        statement = connection.prepareStatement(sql);
	        setParameter(statement, parameters);
	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            result = rowMapper.mapRow(resultSet);
	        }
	        return result;
	    } catch (SQLException e) {
	        // Xử lý ngoại lệ SQLException nếu cần
	        e.printStackTrace();
	        return null;
	    } finally {
	        try {
	            closeJDBC(connection, statement, resultSet);
	        } catch (Exception e) {
	            // Xử lý ngoại lệ nếu cần
	            e.printStackTrace();
	            return null;
	        }
	    }
	}
	public Cart query3(String sql, RowMapper<Cart> rowMapper, Object... parameters) {
	    Cart result = null;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    try {
	        connection = GetConnection();
	        statement = connection.prepareStatement(sql);
	        setParameter(statement, parameters);
	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            result = rowMapper.mapRow(resultSet);
	        }
	        return result;
	    } catch (SQLException e) {
	        // Xử lý ngoại lệ SQLException nếu cần
	        e.printStackTrace();
	        return null;
	    } finally {
	        try {
	            closeJDBC(connection, statement, resultSet);
	        } catch (Exception e) {
	            // Xử lý ngoại lệ nếu cần
	            e.printStackTrace();
	            return null;
	        }
	    }
	}

	@Override
	public void insertCart(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = GetConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
			closeJDBC(connection, statement, null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	
		
	

}

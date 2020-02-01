package com.waylau.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * JDBC Test.
 */
@TestMethodOrder(OrderAnnotation.class)
public class JdbcTest {

	private static final String url = "jdbc:mysql://localhost:3306/lite?"
			+ "useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String user = "root"; // 账号
	private static final String passwd = "123456"; // 密码

	@Test
	@Order(1)
	void testJdbcInsert() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 建立连接
			conn = DriverManager.getConnection(url, user, passwd);

			// 创建Statement
			ps = conn.prepareStatement("INSERT INTO t_host_info "
					+ "(host,create_time,used_memory,total_memory,used_cpu)"
					+ " VALUES (?,?,?,?,?)");

			ps.setString(1, "i@waylau.com");
			ps.setDouble(2, 21312D);
			ps.setDouble(3, 43221D);
			ps.setDouble(4, 67890D);
			ps.setDouble(5, 34567D);

			int insertResult = ps.executeUpdate();
			assertEquals(1, insertResult);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.releaseResources(rs, ps, conn);
		}
	}

	@Test
	@Order(2)
	void testJdbcSelect() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 建立连接
			conn = DriverManager.getConnection(url, user, passwd);

			// 创建Statement
			ps = conn.prepareStatement("SELECT * FROM t_host_info WHERE host=?");
			ps.setString(1, "i@waylau.com");

			rs = ps.executeQuery();

			// 遍历查询每一条记录
			while (rs.next()) {
				String host = rs.getString("host");
				double createTime = rs.getDouble("create_time");
				assertEquals(host, "i@waylau.com");
				assertEquals(createTime, 21312D);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.releaseResources(rs, ps, conn);
		}
	}

	@Test
	@Order(3)
	void testJdbcDelete() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 建立连接
			conn = DriverManager.getConnection(url, user, passwd);

			// 创建Statement
			ps = conn.prepareStatement("DELETE FROM t_host_info WHERE host=?");
			ps.setString(1, "i@waylau.com");

			int deleteResult = ps.executeUpdate();
			assertEquals(1, deleteResult);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.releaseResources(rs, ps, conn);
		}
	}

	/**
	 * 释放连接资源
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	private void releaseResources(ResultSet resultSet, Statement statement, 
			Connection connection) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSet = null;
			try {
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				statement = null;
				try {

					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					connection = null;
				}
			}
		}
	}
}

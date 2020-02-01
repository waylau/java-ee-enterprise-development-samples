package com.waylau.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * DbUtil Test.
 * 
 * @since 2020年2月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(OrderAnnotation.class)
public class DbUtilTest {
	@Test
	@Order(1)
	void testJdbcInsert() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 建立连接
			conn = DbUtil.getConnection();
			
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
			// 释放资源
			DbUtil.releaseResources(rs, ps, conn);
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
			conn = DbUtil.getConnection();
			
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
			// 释放资源
			DbUtil.releaseResources(rs, ps, conn);
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
			conn = DbUtil.getConnection();

			// 创建Statement
			ps = conn.prepareStatement("DELETE FROM t_host_info WHERE host=?");
			ps.setString(1, "i@waylau.com");

			int deleteResult = ps.executeUpdate();
			assertEquals(1, deleteResult);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			DbUtil.releaseResources(rs, ps, conn);
		}
	}
}

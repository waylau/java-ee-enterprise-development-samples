package com.waylau.java;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * DB Util.
 * 
 * @since 2020年2月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class DbUtil {
	public static DataSource dataSource;

	static {
		try {
			InputStream in = 
					DbUtil.class.getClassLoader()
					.getResourceAsStream("lite.properties");
			Properties properties = new Properties();
			properties.load(in);

			// 返回数据源对象
			dataSource = setupDataSource(properties.getProperty("url"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据源
	 * 
	 * @return 数据源
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 从连接池中获取连接
	 * 
	 * @return 连接
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param resultSet  查询结果
	 * @param statement  语句
	 * @param connection 连接
	 */
	public static void releaseResources(ResultSet resultSet, 
			Statement statement, 
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

	/**
	 * 设置数据源
	 * 
	 * @param connectionUri 数据库连接URI
	 * @param properties    连接属性
	 * @return 数据源
	 */
	private static DataSource setupDataSource(final String connectionUri, 
			final Properties properties) {
		ConnectionFactory connectionFactory = 
				new DriverManagerConnectionFactory(connectionUri, properties);
		PoolableConnectionFactory poolableConnectionFactory = 
				new PoolableConnectionFactory(connectionFactory, null);
		ObjectPool<PoolableConnection> connectionPool = 
				new GenericObjectPool<>(poolableConnectionFactory);
		poolableConnectionFactory.setPool(connectionPool);
		PoolingDataSource<PoolableConnection> dataSource = 
				new PoolingDataSource<>(connectionPool);
		return dataSource;
	}

}

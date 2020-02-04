package com.waylau.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.waylau.mybatis.domain.User;
import com.waylau.mybatis.mapper.UserMapper;

/**
 * MyBatis Test.
 * 
 * @since 1.0.0 2020年2月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(OrderAnnotation.class)
public class MyBatisTest {
	private static final Long TEST_USER_ID = 1L;
	private static final String TEST_USER_NAME = "Way Lau";
	private static final String TEST_USER_NAME_2 = "waylau";

	@Test
	@Order(1)
	void testInsert() throws IOException {
		// 读取mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

		// 初始化mybatis，创建SqlSessionFactory类的实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建Session实例
		SqlSession session = sqlSessionFactory.openSession();

		// 获得mapper接口的代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = new User(TEST_USER_ID, TEST_USER_NAME);
		int result = mapper.createUser(user);
		assertEquals(result, 1);

		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

	@Test
	@Order(2)
	void testSelect() throws IOException {
		// 读取mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

		// 初始化mybatis，创建SqlSessionFactory类的实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建Session实例
		SqlSession session = sqlSessionFactory.openSession();

		// 获得mapper接口的代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = mapper.getUser(TEST_USER_ID);
		assertEquals(user.getUserId(), TEST_USER_ID);
		assertEquals(user.getUsername(), TEST_USER_NAME);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

	@Test
	@Order(3)
	void testUpdate() throws IOException {
		// 读取mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

		// 初始化mybatis，创建SqlSessionFactory类的实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建Session实例
		SqlSession session = sqlSessionFactory.openSession();

		// 获得mapper接口的代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = new User(TEST_USER_ID, TEST_USER_NAME_2);
		int result = mapper.updateUser(user);

		assertEquals(result, 1);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}
	
	@Test
	@Order(4)
	void testelete() throws IOException {
		// 读取mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

		// 初始化mybatis，创建SqlSessionFactory类的实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 创建Session实例
		SqlSession session = sqlSessionFactory.openSession();

		// 获得mapper接口的代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);

		int result = mapper.deleteUser(TEST_USER_ID);

		assertEquals(result, 1);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}
}

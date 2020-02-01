/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.di.service;

/**
 * Message Service Impl.
 * 
 * @since 1.0.0 2020年2月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MessageServiceImpl implements MessageService {
	
	private String username;
	private int age;
	
	public MessageServiceImpl(String username, int age) {
		this.username = username;
		this.age = age;
	}
	
	public String getMessage() {
		return "Hello World! " + username + ", age is " + age;
	}

}

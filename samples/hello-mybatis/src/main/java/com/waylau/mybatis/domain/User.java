/**
 * Welcome to https://waylau.com
 */
package com.waylau.mybatis.domain;

/**
 * User.
 * 
 * @since 1.0.0 2020年2月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class User {

	private Long userId;
	private String username;

	public User(Long userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}

}

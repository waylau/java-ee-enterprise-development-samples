/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.aop;

/**
 * Fighter.
 * 
 * @since 1.0.0 2020年2月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Fighter {

	public void foundBefore() {
		System.out.println("Fighter wait for tiger...");
	}

	public void foundAfter() {
		System.out.println("Fighter fight with tiger...");
	}

}

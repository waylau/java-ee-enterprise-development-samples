/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Main.
 * 
 * @since 1.0.0 2020年2月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}

}

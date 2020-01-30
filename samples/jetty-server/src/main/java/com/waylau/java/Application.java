package com.waylau.java;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Application Main.
 * 
 * @since 2020年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 新建一个Jetty的服务器，并启动在8080端口
		Server server = new Server(8080);

		// 创建处理器
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);

		// URL映射到Servlet
		handler.addServletWithMapping(HelloServlet.class, "/HelloServlet");

		// 启动服务器
		server.start();
		server.join();
	}

}

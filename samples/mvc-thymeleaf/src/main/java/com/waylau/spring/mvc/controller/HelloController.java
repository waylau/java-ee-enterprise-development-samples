package com.waylau.spring.mvc.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello 控制器.
 * 
 * @since 2020年2月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Controller
public class HelloController {

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title", "Thymeleaf Demo");
		model.addAttribute("header", "老卫作品集");
		model.addAttribute("books",
				Arrays.asList("《分布式系统常用技术及案例分析》", 
						"《Spring Boot 企业级应用开发实战》", 
						"《Spring Cloud 微服务架构开发实战》",
						"《Spring 5 开发大全》", 
						"《Cloud Native 分布式架构原理与实践》", 
						"《Angular企业级应用开发实战》", 
						"《大型互联网应用轻量级架构实战》"));
		return "index";
	}

}

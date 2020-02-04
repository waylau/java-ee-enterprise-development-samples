package com.waylau.spring.mvc.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configuration.
 * 
 * @since 1.0.0 2018年12月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebMvc // 启用MVC
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	public void extendMessageConverters(List<HttpMessageConverter<?>> cs) {
		// 使用Jackson JSON来进行消息转换
		cs.add(new MappingJackson2HttpMessageConverter());
	}
}

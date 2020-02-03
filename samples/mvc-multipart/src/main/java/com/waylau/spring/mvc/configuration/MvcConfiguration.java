package com.waylau.spring.mvc.configuration;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configuration.
 * 
 * @since 2020年2月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new MappingJackson2XmlHttpMessageConverter());
//	}
	
	@Bean
    public MultipartResolver multipartResolver() throws IOException{
        return new StandardServletMultipartResolver();
    }
}

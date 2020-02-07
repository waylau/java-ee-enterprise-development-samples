package com.waylau.spring.cache.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC Configuration.
 * 
 * @since 1.0.0 2020年2月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
}

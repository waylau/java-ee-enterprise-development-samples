package com.waylau.spring.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * App Configuration.
 * 
 * @since 2020年2月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
@ComponentScan(basePackages = { "com.waylau.spring" })  
@Import({ MvcConfiguration.class })
public class AppConfiguration {

}

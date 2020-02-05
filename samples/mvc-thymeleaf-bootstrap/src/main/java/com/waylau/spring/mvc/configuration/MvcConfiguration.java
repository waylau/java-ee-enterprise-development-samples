package com.waylau.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * MVC Configuration.
 * 
 * @since 2020年2月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebMvc
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	public final static String CHARACTER_ENCODING = "UTF-8";
	public final static String TEMPLATE_PREFIX = "classpath:/templates/";
	public final static String TEMPLATE_SUFFIX = ".html";
	public final static Boolean TEMPLATE_CACHEABLE = false;
	public final static String TEMPLATE_MODE = "HTML5";
	public final static Integer TEMPLATE_ORDER = 1;

	/**
	 * 模板解析器
	 * @return
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix(TEMPLATE_PREFIX);
		templateResolver.setSuffix(TEMPLATE_SUFFIX);
		templateResolver.setCacheable(TEMPLATE_CACHEABLE);
		templateResolver.setCharacterEncoding(CHARACTER_ENCODING);
		templateResolver.setTemplateMode(TEMPLATE_MODE);
		templateResolver.setOrder(TEMPLATE_ORDER);
		return templateResolver;
	}

	/**
	 * 模板引擎
	 * @param templateResolver
	 * @return
	 */
	@Bean
	public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}

	/**
	 * 视图解析器
	 * @param springTemplateEngine
	 * @return
	 */
	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine springTemplateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(springTemplateEngine);
		viewResolver.setCharacterEncoding(CHARACTER_ENCODING);
		return viewResolver;
	}
}

package com.cmz.myweb.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.cmz.myweb.interceptor.SystemInterceptor;

@Configuration
@ComponentScan(basePackages = {"com.cmz.myweb.controller", "com.cmz.myweb.service" })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * 支持JSON
	 * 
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.parseMediaType("application/json;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8"));
		converter.setSupportedMediaTypes(supportedMediaTypes);
		return converter;
	}

	/**
	 * @ResponseBody 编码问题
	 * @param stringHttpMessageConverter
	 * @return
	 */
//	@Bean
//	public RequestMappingHandlerAdapter requestMappingHandlerAdapter(
//			StringHttpMessageConverter stringHttpMessageConverter) {
//		RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
//		converters.add(stringHttpMessageConverter);
//		converters.add(mappingJackson2HttpMessageConverter());
//		adapter.setMessageConverters(converters);
//		return adapter;
//	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.parseMediaType("text/plain;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("applicaiton/javascript;charset=UTF-8"));
		converter.setSupportedMediaTypes(supportedMediaTypes);

		return converter;
	}

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping(HandlerInterceptor handlerInterceptor) {
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		mapping.setInterceptors(handlerInterceptor);
		return mapping;
	}

	@Bean
	public HandlerInterceptor handlerInterceptor() {
		SystemInterceptor interceptor = new SystemInterceptor();
		return interceptor;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/views/");
		Properties settings = new Properties();
		settings.setProperty("default_encoding", "UTF-8");
		settings.setProperty("locale", "zh_CN");
		configurer.setFreemarkerSettings(settings);
		configurer.setDefaultEncoding("UTF-8");
		return configurer;
	}

	@Bean
	public ContentNegotiatingViewResolver contentViewResolver(ServletContext context) throws Exception {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
/*
		 InternalResourceViewResolver viewResolver = new
		 InternalResourceViewResolver();
		 viewResolver.setPrefix("/WEB-INF/jsp/");
		 viewResolver.setSuffix(".jsp");
		 */
		
		UrlBasedViewResolver freeMarkerViewResolver = new UrlBasedViewResolver();
		freeMarkerViewResolver.setSuffix(".html");
		freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
		
		 
		// =========================thymeleaf=============
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
		templateResolver.setPrefix("/WEB-INF/thymeleaf/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("utf-8");
		templateResolver.setOrder(1);
		templateResolver.setCacheable(false);

		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);
		// engine.addDialect(new DataTablesDialect());
		// engine.addDialect(new LayoutDialect());
		// engine.addDialect(new ButtonAuthDialect());

		ThymeleafViewResolver thymeleafResolver = new ThymeleafViewResolver();
		thymeleafResolver.setTemplateEngine(engine);
		thymeleafResolver.setCharacterEncoding("utf-8");
		
		// =========================thymeleaf=============
		 
		 
		MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
		defaultView.setExtractValueFromSingleKeyModel(true);

		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
		contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
		contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(thymeleafResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
		return contentViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
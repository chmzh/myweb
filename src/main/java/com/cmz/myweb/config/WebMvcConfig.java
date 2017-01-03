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
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.cmz.myweb.handler.GlobalDefaultExceptionHandler;
import com.cmz.myweb.interceptor.CsrfInterceptor;
import com.cmz.myweb.interceptor.SystemInterceptor;

@Configuration
@ComponentScan(basePackages = {"com.cmz.myweb.controller","com.cmz.myweb.admin.controller", "com.cmz.myweb.service","com.cmz.myweb.admin.service" })
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


//	@Bean
//	public WebExceptionHandler webExceptionHandler(){
//		return new WebExceptionHandler();
//	}
	
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
		return new SimpleMappingExceptionResolver();
	}
	
	/**
	 * 异常统一处理
	 * @return
	 */
//	@Bean
//	public GlobalDefaultExceptionHandler globalDefaultExceptionHandler(){
//		return new GlobalDefaultExceptionHandler();
//	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		mapping.setInterceptors(handlerInterceptor(),csrfHandlerInterceptor());
		return mapping;
	}

	@Bean
	public HandlerInterceptor csrfHandlerInterceptor() {
		CsrfInterceptor interceptor = new CsrfInterceptor();
		return interceptor;
	}
	
	@Bean
	public HandlerInterceptor handlerInterceptor() {
		SystemInterceptor interceptor = new SystemInterceptor();
		return interceptor;
	}
//	@Bean
//	public RequestDataValueProcessor referenceInsertExecutor(){
//		CsrfRequestDataValueProcessor processor = new CsrfRequestDataValueProcessor();
//		return processor;
//	}
	
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
	public VelocityConfig velocityConfig(){
		VelocityConfigurer configurer = new VelocityConfigurer();
		configurer.setResourceLoaderPath("/WEB-INF/views/");
		Properties settings = new Properties();
		settings.setProperty("input.encoding", "UTF-8");
		settings.setProperty("utput.encoding", "UTF-8");
		configurer.setVelocityProperties(settings);
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
		
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setSuffix(".html");
		urlBasedViewResolver.setContentType("text/html; charset=utf-8");
		//urlBasedViewResolver.setViewClass(FreeMarkerView.class);
		urlBasedViewResolver.setViewClass(VelocityView.class);
		
		 
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
		contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(urlBasedViewResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
		return contentViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}

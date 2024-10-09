package com.unchart.map;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	/*
    public void addInterceptors(InterceptorRegistry registry) {
//    pattern 은 ** 를 사용해야 함. *는 안됨.
//    	String requestRoot = UncConstants.CONTEXT_ROOT + "/" + UncConstants.APP_NAME + "/**";
    	String includePath = UncConstants.CONTEXT_ROOT + "/**";
    	String excludePath = UncConstants.CONTEXT_ROOT + "/static/**";
		registry.addInterceptor(new UncInterceptor()).addPathPatterns(includePath).excludePathPatterns(excludePath);
		registry.addInterceptor(new BizInterceptor()).addPathPatterns(includePath).excludePathPatterns(excludePath);
    }
    */
	
    /**
     * controller mapping 없이 view 요청 
     */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		//registry.addViewController("/error").setViewName("error");
	}
	
	/**
	 * jsp view resolver 사용
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {
		String prefix = "/WEB-INF/views/jsp/";
		String suffix = ".jsp";
		registry.jsp(prefix, suffix);
	}
	
	/**
	 * 정적 리소스 핸들러 
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String location = "classpath:/static/";
		registry.addResourceHandler("/static/**").addResourceLocations(location).setCachePeriod(-1);
	}
}

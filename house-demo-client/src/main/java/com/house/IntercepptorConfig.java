package com.house;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.house.tool.CoustomerSessionInterceptor;

// 拦截器配置类
@Configuration
public class IntercepptorConfig implements WebMvcConfigurer {

	/**
	 * 注入自定义拦截器
	 * 
	 * @Title: addInterceptors
	 * @Description: 先add的拦截器会越靠外，即越靠近浏览器
	 * @author OnlyMate
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截所有请求
		registry.addInterceptor(new CoustomerSessionInterceptor()).addPathPatterns("/house/session/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}

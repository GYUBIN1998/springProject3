package com.group3.springProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.group3.springProject.interceptor.LoginCheckInterceptor;
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer{
	@Autowired
	LoginCheckInterceptor loginCheckInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	}
}

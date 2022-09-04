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
		//로그인 한 사람만 insert,update delete 가능
		registry.addInterceptor(loginCheckInterceptor)
//				.addPathPatterns("/*/insert.*")
//				.addPathPatterns("/*/insert/*")
//				.addPathPatterns("/*/update.*")
//				.addPathPatterns("/*/update/*")
//				.addPathPatterns("/*/delete.*")
//				.addPathPatterns("/*/delete/*")
				.addPathPatterns("/user/**")
				.excludePathPatterns("/user/login.do")
				.excludePathPatterns("/user/signup.do")
				.addPathPatterns("/board/**")
				.excludePathPatterns("/board/list/**")
				.excludePathPatterns("/board/detail/**");
	}
}

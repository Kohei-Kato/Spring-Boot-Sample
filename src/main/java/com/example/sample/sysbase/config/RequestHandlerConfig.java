package com.example.sample.sysbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.example.sample.sysbase.interceptor.HttpRequestHandlerInterceptor;

@Configuration
public class RequestHandlerConfig extends WebMvcConfigurationSupport {
	
    /**
     * interceptorをbeanに登録
     */
    @Bean
    public HttpRequestHandlerInterceptor requestHandlerInterceptor() {
    	return new HttpRequestHandlerInterceptor();
    }
    
    /**
     * intercptorのbeanをurlリクエストパターンに追加
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {    	
        // リクエストパスが /sample の形をとるAPIに対し、作成したHandlerInterceptorを適応。
        registry.addInterceptor(requestHandlerInterceptor()).addPathPatterns("/sample");
    }
}

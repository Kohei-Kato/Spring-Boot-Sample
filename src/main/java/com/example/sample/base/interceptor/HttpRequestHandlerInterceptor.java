package com.example.sample.base.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HttpRequestHandlerInterceptor implements HandlerInterceptor {
	
	
	Logger logger = LoggerFactory.getLogger(HttpRequestHandlerInterceptor.class);
	
	/**
	 * handlerが実行される前の共通処理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 共通処理を記述する。		
		logger.info("[preHandle]" + request.getRequestURI());
		
		// ひとまず、すべてのリクエストを許可
		return true;

	}

	/**
	 * Viewによるrender処理が完了した後の共通処理.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		
		// 共通処理を記述する。		
		logger.info("[afterCompletion]" + request.getRequestURI());
	}

	/**
	 * handlerが実行された後の共通処理
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
			throws Exception {
		
		// 共通処理を記述する。		
		logger.info("[postHandle]" + request.getRequestURI());

	}
}

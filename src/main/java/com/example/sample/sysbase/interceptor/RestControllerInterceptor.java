package com.example.sample.sysbase.interceptor;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.sample.web.apbase.application.form.BaseOutputForm;

@Aspect
@Component
public class RestControllerInterceptor {

	Logger logger = LoggerFactory.getLogger(RestControllerInterceptor.class);

	/**
	 * @RestControllerが付与されたクラスのメソッドからExceptionがthrowされた時のログ出力.
	 * 
	 * @param point
	 * @param ret
	 */
	@AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController)", throwing = "ret")
	public void afterThrowing(JoinPoint point, Throwable ret) {

		// ログ出力
		logger.warn("例外が発生しました.Controller={} Exception={}", point.getTarget().toString(), ret.toString());

	}

	/**
	 * RestController実行前後のデバッグログ出力.
	 * @param joinpoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@within(org.springframework.web.bind.annotation.RestController)")
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {

		logger.info("[@RestController　メソッド開始:] " + joinpoint.getSignature());

		// 実行
		Object result = joinpoint.proceed();

		logger.info("[@RestController　メソッド終了:] " + joinpoint.getSignature() + "戻り値 = " + result);
		
		return result;

	}

}

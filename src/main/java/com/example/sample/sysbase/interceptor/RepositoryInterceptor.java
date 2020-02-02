package com.example.sample.sysbase.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryInterceptor {
	
	/**
	 * @Servicerが付与されたクラスのメソッドから実行された時の処理.
	 * 
	 * @param point
	 */
	@Before(value = "@within(org.springframework.stereotype.Service)")
	public void before(JoinPoint point) {
		
		// 例外制御（未実装）		
		System.out.println("[Service実行前　共通処理]" + point.getTarget().toString());
		
	}
	
	/**
	 * @Servicerが付与されたクラスのメソッドから実行された後の処理.
	 * 
	 * @param point
	 */
	@After(value = "@within(org.springframework.stereotype.Service)")
	public void after(JoinPoint point) {
		
		// 例外制御（未実装）		
		System.out.println("[Service実行後　共通処理]" + point.getTarget().toString());
	}

}

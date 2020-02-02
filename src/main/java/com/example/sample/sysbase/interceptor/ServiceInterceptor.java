package com.example.sample.sysbase.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceInterceptor {
	
	/**
	 * @Repositoryが付与されたクラスのメソッドから実行された時の処理.
	 * 
	 * @param point
	 */
	@Before(value = "@within(org.springframework.stereotype.Repository)")
	public void before(JoinPoint point) {
		
		// 例外制御（未実装）		
		System.out.println("[Repository実行前　共通処理]" + point.getSignature());
		System.out.println("[Repository実行前　共通処理]引数出力");
			
	    Object[] objArray = point.getArgs();
	    int i = 1;
	    for (Object obj : objArray) {
	        System.out.println("引数" + i + " : " + obj.toString());
	    }
	}
	
	/**
	 * @Repositoryが付与されたクラスのメソッドから実行された後の処理.
	 * 
	 * @param point
	 */
	@After(value = "@within(org.springframework.stereotype.Repository)")
	public void after(JoinPoint point) {
		
		// 例外制御（未実装）		
		System.out.println("[Repository実行後　共通処理]" + point.getSignature().toShortString());
	}

}

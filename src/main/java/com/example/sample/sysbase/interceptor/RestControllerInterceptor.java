package com.example.sample.sysbase.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerInterceptor {
	
	/**
	 * @RestControllerが付与されたクラスのメソッドからExceptionがthrowされた時の処理.
	 * 
	 * @param point
	 * @param ret
	 */
	@AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController)", throwing = "ret")
	public void afterThrowing(JoinPoint point, Throwable ret) {
		
		// 例外制御（未実装）
		
		// ログ出力
		System.out.println("例外が発生しました.");
		System.out.println("実行コントローラー" + point.getTarget().toString());
		ret.printStackTrace();
		
		
	}

}

package com.example.sample.sysbase.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.sample.sysbase.exception.SampleBusinessException;
import com.example.sample.sysbase.exception.SampleSytemException;

@Aspect
@Component
public class ExceptionInterceptor {
	
	/**
	 * @RestControllerが付与されたクラスのメソッドからExceptionがthrowされた時の処理.
	 * 
	 * @param point
	 * @param ret
	 */
	@AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController)", throwing = "ret")
	public void afterThrowing(JoinPoint point, Throwable ret) {
		
		// ログ出力
		System.out.println("例外が発生しました.");
		System.out.println("実行コントローラー" + point.getTarget().toString());
		ret.printStackTrace();
		
		// 例外制御（未実装）
		if (SampleBusinessException.class.equals(ret.getClass())) {
			//業務例外の場合

		} else if (SampleSytemException.class.equals(ret.getClass())) {
			//システム例外の場合

		} else {
			//その他の例外の場合
			SampleSytemException exception = new SampleSytemException(ret);
			
		}		
		
	}

}

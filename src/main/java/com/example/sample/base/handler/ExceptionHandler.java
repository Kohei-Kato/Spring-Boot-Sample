package com.example.sample.base.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandler {
	
	/**
	 * @RestController���t�^���ꂽ�N���X�̃��\�b�h����Exception��throw���ꂽ���̏���.
	 * 
	 * @param point
	 * @param ret
	 */
	@AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController)", throwing = "ret")
	public void afterThrowing(JoinPoint point, Throwable ret) {
		
		// ��O����i�������j
		System.out.println("��O���������܂���.");
		System.out.println("���s�R���g���[���[" + point.getTarget().toString());
		ret.printStackTrace();
		
		
	}

}

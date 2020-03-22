package com.example.sample.sysbase.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample.web.apbase.application.form.BaseOutputForm;


@RestControllerAdvice
public class SampleControllerAdvice {

	Logger logger = LoggerFactory.getLogger(SampleControllerAdvice.class);

	/**
	 * @RestControllerが付与されたクラスのメソッドからExceptionがthrowされた時の処理.
	 * 
	 * @param e Controllerからthrowされた例外
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseOutputForm handleMyException(Exception e, WebRequest req) {

		logger.warn("例外が発生しました.", e);

		BaseOutputForm outputForm = new BaseOutputForm();
		outputForm.setMessage("例外が発生しました");
		outputForm.setResult(false);

		return outputForm;

	}

}

package com.example.sample.web.api1.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.sysbase.enviroment.ApplicationEnviroment;
import com.example.sample.sysbase.exception.SampleBusinessException;
import com.example.sample.web.apbase.application.form.BaseOutputForm;
import com.example.sample.web.api1.application.form.InputForm;
import com.example.sample.web.api1.application.form.OutputForm;
import com.example.sample.web.api1.domain.SampleService;
import com.example.sample.web.api1.domain.dto.InputDto;
import com.example.sample.web.api1.domain.dto.OutputDto;

import java.util.Locale;

import org.dozer.Mapper;

@RestController
public class SampleControler {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SampleService sampleService;

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private ApplicationEnviroment enviroment;

	@GetMapping("/sample")
	public OutputForm executeGet(InputForm inputForm) {

		InputDto inputData = new InputDto();
		
		OutputDto outputData = sampleService.execute(inputData);

		// サービス実行結果をコントローラーの復帰値に設定
		OutputForm outputForm = new OutputForm();

		if ("000".equals(outputData.getResultCode())) {
			// Serviceが正常終了した場合
			mapper.map(outputData, outputForm);
			outputForm.setResult(true);
			outputForm.setResultCode("0");
			outputForm.setMessage(messageSource.getMessage("app.message.sample.normal.001", null, Locale.JAPAN));
			
		} else {
			// Serviceが異常終了した場合
			outputForm.setResult(false);
			outputForm.setResultCode("1");
			outputForm.setMessage(messageSource.getMessage("app.message.sample.err.001", null, Locale.JAPAN));
			
		}
		
		// 環境依存値より、アクティブな環境名を取得
		String value = enviroment.getValue("test");
		outputForm.setEnviroment(value);

		BaseOutputForm base = (BaseOutputForm)outputForm;
		
//		throw new SampleBusinessException();
		
		return outputForm;
		
//		return new Object();
	}

}

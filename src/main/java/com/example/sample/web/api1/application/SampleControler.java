package com.example.sample.web.api1.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.web.api1.application.form.InputForm;
import com.example.sample.web.api1.application.form.OutputForm;
import com.example.sample.web.api1.domain.SampleService;
import com.example.sample.web.api1.domain.dto.InputDto;
import com.example.sample.web.api1.domain.dto.OutputDto;

import org.dozer.Mapper;

@RestController
public class SampleControler {

	@Autowired
	private SampleService sampleService;

	@Autowired
	private Mapper mapper;

	@GetMapping("/sample")
	public OutputForm executeGet(InputForm inputForm) {

		InputDto inputData = new InputDto();

		OutputDto outputData = sampleService.execute(inputData);

		// サービス実行結果をコントローラーの復帰値に設定
		OutputForm outputForm = new OutputForm();

		if ("000".equals(outputData.getResultCode())) {
			// Serviceが正常終了した場合
			mapper.map(outputData, outputForm);
			outputForm.setResultCode("0");
			outputForm.setMessage("SampleAPIが正常終了しました。");
			
		} else {
			// Serviceが異常終了した場合
			outputForm.setResultCode("1");
			outputForm.setMessage("SampleAPIが異常終了しました。");
			
		}

		return outputForm;
	}

}

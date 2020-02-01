package com.example.sample.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.web.domain.InputData;
import com.example.sample.web.domain.OutputData;
import com.example.sample.web.domain.SampleService;

import org.dozer.Mapper;

@RestController
public class SampleControler {
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private Mapper mapper;

	@GetMapping("/sample")
	public OutputForm executeGet(InputForm inputForm) {
	
		InputData inputData = new InputData();
		
		OutputData outputData = sampleService.execute(inputData);
		
		//�T�[�r�X���s���ʂ��R���g���[���[�̕��A�l�ɐݒ�
		OutputForm outputForm = new OutputForm();
		mapper.map(outputData, outputForm);
		
		return outputForm;
	}
	
}

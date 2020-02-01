package com.example.sample.web.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.base.exception.SampleBusinessException;
import com.example.sample.base.parts.CommonSytemParts;
import com.example.sample.web.domain.dto.InputData;
import com.example.sample.web.domain.dto.OutputData;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private CommonSytemParts commonSystemParts;
	
	@Override
	public OutputData execute(InputData input) {
		
		OffsetDateTime time = commonSystemParts.getCurrentTime();
		
		OutputData output = new OutputData();
		
		output.setKey1("test33");
		output.setTime(time.toString());
		
//		throw new SampleBusinessException();
		
		return output;
	}

}

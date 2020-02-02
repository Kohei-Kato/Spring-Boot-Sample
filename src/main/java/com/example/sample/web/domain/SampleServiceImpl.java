package com.example.sample.web.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.sysbase.exception.SampleBusinessException;
import com.example.sample.sysbase.parts.CommonSytemParts;
import com.example.sample.web.Infrastructure.SampleRepository;
import com.example.sample.web.Infrastructure.entity.SampleEntity;
import com.example.sample.web.domain.dto.InputData;
import com.example.sample.web.domain.dto.OutputData;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private CommonSytemParts commonSystemParts;
	
	@Autowired
	private SampleRepository sampleRepository;
	
	/**
	 * 業務処理
	 */
	@Override
	public OutputData execute(InputData input) {
		

		
		//DBの参照
		SampleEntity sampleEntity = sampleRepository.selectSample(1);

		OffsetDateTime time = commonSystemParts.getCurrentTime();
		
		//DBの更新
		sampleEntity.setContents("更新しました。");
		sampleEntity.setUpdateTime(time);
		sampleRepository.updateSample(sampleEntity);
		
		//復帰値の作成
		OutputData output = new OutputData();
		output.setKey1("test33");
		output.setTime(time.toString());
		
		return output;
	}

}

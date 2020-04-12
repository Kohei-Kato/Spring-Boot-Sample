package com.example.sample.web.api001.domain;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.sysbase.parts.CommonSytemParts;
import com.example.sample.web.api001.Infrastructure.SampleRepository;
import com.example.sample.web.api001.Infrastructure.entity.SampleEntity;
import com.example.sample.web.api001.domain.dto.InputDto;
import com.example.sample.web.api001.domain.dto.OutputDto;

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
	public OutputDto execute(InputDto input) {

		//DBの参照
		SampleEntity sampleEntity = sampleRepository.selectSample(1);

		OffsetDateTime time = commonSystemParts.getCurrentTime();
		
		//DBの更新
		sampleEntity.setContents("更新しました。");
		sampleEntity.setUpdateTime(time);
		sampleRepository.updateSample(sampleEntity);
		
		//復帰値の作成
		OutputDto output = new OutputDto();
		output.setKey1("test33");
		output.setTime(time.toString());
		
		output.setResultCode("000");
		output.setMessage("正常に終了しました。");
		
		return output;
	}

}

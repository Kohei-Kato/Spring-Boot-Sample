package com.example.sample.web.api1.Infrastructure;

import com.example.sample.web.api1.Infrastructure.entity.SampleEntity;

public interface SampleRepository {
	
	/**
	 * idでSampleテーブルをselect.
	 * @param id selectのキー
	 * @return
	 */
	public SampleEntity selectSample(int id) ;
	
	/**
	 * entityの内容でSampleテーブルをupdate.
	 * @param entity
	 */
	public void updateSample(SampleEntity entity) ;

}
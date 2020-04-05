package com.example.sample.web.api1.Infrastructure;

import org.springframework.stereotype.Repository;

import com.example.sample.web.api1.Infrastructure.entity.SampleEntity;

/**
 * Mapperを使えば実装クラスは作成する必要はない.今回はDBがない状態で動作させるために作成.
 * @author kohe5
 */
@Repository
public class SampleRepositoryImpl implements SampleRepository {

	@Override
	public SampleEntity selectSample(int id) {
		SampleEntity entity = new SampleEntity();
		entity.setId(id);
		return entity;
	}

	@Override
	public void updateSample(SampleEntity entity) {
		// TODO DBがないため処理なし
		
	}

}

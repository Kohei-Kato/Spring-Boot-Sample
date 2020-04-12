package com.example.sample.web.api001.Infrastructure.entity;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * DBのテーブルに対応したEntity
 * @author kohe5
 *
 */
@Data
public class SampleEntity {

	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * データ内容
	 */
	private String contents;
	
	/**
	 * 更新日時
	 */
	private OffsetDateTime updateTime;
	
	/**
	 * 登録日時
	 */
	private OffsetDateTime createTime;
}

package com.example.sample.web.apbase.domain.dto;

import lombok.Data;

/**
 * Serviceの共通アウトプットデータ.
 * @author kohe5
 *
 */
@Data
public class BaseOutputDto {

	/**
	 * Serviceの終了メッセージ.
	 */
	private String message;
	
	/**
	 * Serviceの処理結果コード
	 */
	private String resultCode;
}

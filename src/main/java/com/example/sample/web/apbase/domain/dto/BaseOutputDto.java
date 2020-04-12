package com.example.sample.web.apbase.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Serviceの共通アウトプットデータ.
 * @author kohe5
 *
 */
@Setter
@Getter
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

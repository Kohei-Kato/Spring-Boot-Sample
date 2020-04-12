package com.example.sample.web.apbase.application.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * APIの共通アウトプットデータ.
 * @author kohe5
 *
 */
@Setter
@Getter
public class BaseOutputForm {
	
	/**
	 * APIの終了メッセージ.
	 */
	private String message;
	
	/**
	 * APIの処理結果.
	 */
	private boolean result;
	
	/**
	 * APIの処理結果コード
	 */
	private String resultCode;
	
}

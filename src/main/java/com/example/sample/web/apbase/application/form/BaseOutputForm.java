package com.example.sample.web.apbase.application.form;

import lombok.Data;

/**
 * APIの共通アウトプットデータ.
 * @author kohe5
 *
 */
@Data
public class BaseOutputForm {
	
	/**
	 * APIの終了メッセージ.
	 */
	private String message;
	
	/**
	 * APIの処理結果コード
	 */
	private String resultCode;
	
}

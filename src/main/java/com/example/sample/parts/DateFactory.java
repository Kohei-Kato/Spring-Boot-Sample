package com.example.sample.parts;

import java.time.OffsetDateTime;

/**
 * 時刻関連の部品
 * @author kohe5
 *
 */
public interface DateFactory {
	
	/**
	 * 現在時刻取得
	 * @return
	 */
	public OffsetDateTime getCurrentTime();

}

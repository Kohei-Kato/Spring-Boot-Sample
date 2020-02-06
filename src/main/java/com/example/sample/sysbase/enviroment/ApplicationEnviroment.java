package com.example.sample.sysbase.enviroment;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

/**
 * application.ymlに設定したアプリケーション用の環境依存値を取得するクラス.
 * @author kohe5
 *
 */
@Setter
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationEnviroment {

	/** application.ymlのapp.envは以下の値を格納したMap. */
	private Map<String, String> env;

	/**
	 * application.ymlで設定した値を取得.
	 * @param key ymlの項目名
	 * @return keyに対応した値
	 */
	public String getValue(@NotBlank String key) {
		return env.get(key);
	}

}

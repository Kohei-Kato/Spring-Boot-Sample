package com.example.sample.sysbase.communication;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.sample.sysbase.exception.SampleSytemException;

/**
 * 外部システムに通信を行うクラス.
 *
 */
@Component
public class SampleRestClient {

	private RestTemplate restTemplate;

	private URI uri;

	public SampleRestClient(@Autowired RestTemplateBuilder builder, @Value("sysbase.restclient.uri") String uri,
			@Value("${sysbase.restclient.readTimeout:3}") Integer readTimeout,
			@Value("${sysbase.restclient.connectTimeout:3}") Integer connectTimeout) {

		try {
			this.uri = new URI(uri);
		} catch (URISyntaxException e) {
			// URIの生成に失敗した場合、例外をスローして起動失敗させる
			throw new SampleSytemException(e);
		}

		restTemplate = builder.setReadTimeout(Duration.ofSeconds(readTimeout))
				.setConnectTimeout(Duration.ofSeconds(connectTimeout)).build();
		
		// Basic認証が必要な場合、buildの前に以下の処理を追加
		//	builder.basicAuthentication(username, password)
	}

	/**
	 * JSON形式のリクエストをPOSTで送信.
	 */
	public String postJSONRequest(String requestBody) {

		RequestEntity<String> requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).body(requestBody);

		String response = null;
		
		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
			response = responseEntity.getBody();
			
		}catch(HttpClientErrorException | HttpServerErrorException e) {
			// HTTP 4xx,5xx系のエラー
			System.out.println("HTTPステータスコード：" + e.getStatusCode());
			e.printStackTrace();
			
			response = e.getResponseBodyAsString();
			
		}catch(Exception e) {
			// その他のエラー
			e.printStackTrace();
		}

		return response;
	}

}

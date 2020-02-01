package com.example.sample.base.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

	Logger logger = LoggerFactory.getLogger(RestTemplateLoggingInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		// リクエストの中身をログに落とす
		log.info("RestTemplate Request: URI={}, Headers={}, Body={}", request.getURI(), request.getHeaders(),
				new String(body));

		return null;
	}

}

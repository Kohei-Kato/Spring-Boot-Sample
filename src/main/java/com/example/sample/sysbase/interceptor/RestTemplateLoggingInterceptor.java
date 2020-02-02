package com.example.sample.sysbase.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

	Logger logger = LoggerFactory.getLogger(RestTemplateLoggingInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		// リクエストの中身をログに落とす
		logger.info("RestTemplate Request: URI={}, Headers={}, Body={}", request.getURI(), request.getHeaders(),
				new String(body));

		return null;
	}

}

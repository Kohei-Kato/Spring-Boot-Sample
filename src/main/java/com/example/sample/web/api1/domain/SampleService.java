package com.example.sample.web.api1.domain;

import com.example.sample.web.api1.domain.dto.InputData;
import com.example.sample.web.api1.domain.dto.OutputData;

public interface SampleService {
	public OutputData execute(InputData input);
}

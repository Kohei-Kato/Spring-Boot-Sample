package com.example.sample.web.domain;

import com.example.sample.web.domain.dto.InputData;
import com.example.sample.web.domain.dto.OutputData;

public interface SampleService {
	public OutputData execute(InputData input);
}

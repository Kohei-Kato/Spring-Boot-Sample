package com.example.sample.web.api1.domain;

import com.example.sample.web.api1.domain.dto.InputDto;
import com.example.sample.web.api1.domain.dto.OutputDto;

public interface SampleService {
	public OutputDto execute(InputDto input);
}

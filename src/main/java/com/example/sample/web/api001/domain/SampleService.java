package com.example.sample.web.api001.domain;

import com.example.sample.web.api001.domain.dto.InputDto;
import com.example.sample.web.api001.domain.dto.OutputDto;

public interface SampleService {
	public OutputDto execute(InputDto input);
}

package com.example.sample.web.api001.domain.dto;


import com.example.sample.web.apbase.domain.dto.BaseOutputDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OutputDto extends BaseOutputDto{

	private String key1;
	
	private String time;
}

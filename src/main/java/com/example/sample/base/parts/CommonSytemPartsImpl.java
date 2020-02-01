package com.example.sample.base.parts;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonSytemPartsImpl implements CommonSytemParts {

	@Autowired
	private DateFactory dateFactory;
	
	@Override
	public OffsetDateTime getCurrentTime() {
		
		return dateFactory.getCurrentTime();
	}

}

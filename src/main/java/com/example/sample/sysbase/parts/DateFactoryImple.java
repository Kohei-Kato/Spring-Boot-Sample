package com.example.sample.sysbase.parts;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateFactoryImple implements DateFactory {

	@Override
	public OffsetDateTime getCurrentTime() {
		OffsetDateTime dateTime =  OffsetDateTime.now();
		return dateTime;
	}

}

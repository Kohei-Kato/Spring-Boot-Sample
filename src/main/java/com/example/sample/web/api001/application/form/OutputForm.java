package com.example.sample.web.api1.application.form;

import com.example.sample.web.apbase.application.form.BaseOutputForm;

import lombok.Data;

@Data
public class OutputForm extends BaseOutputForm {

	private String key1;

	private String time;

	private String enviroment;
}

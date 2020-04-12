package com.example.sample.web.api001.application.form;

import com.example.sample.web.apbase.application.form.BaseOutputForm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OutputForm extends BaseOutputForm {

	private String key1;

	private String time;

	private String enviroment;
}

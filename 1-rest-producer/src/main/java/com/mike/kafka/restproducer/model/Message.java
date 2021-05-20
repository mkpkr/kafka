package com.mike.kafka.restproducer.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Message {
	
	@NotBlank
	private String data;
	
	//meaningless field for validation example
	@DecimalMin("15.0")
	@DecimalMax("120.0")
	BigDecimal something;
}

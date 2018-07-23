package com.example.demoexceptionlib.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseErrorDTO {
	private String timestamp;
	private String code;	
	private String message;


}

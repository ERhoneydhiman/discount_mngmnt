package com.ex.main.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponce {
	private Integer errorCode;
	private String errorMsg;
}


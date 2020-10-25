package br.com.insight.ufc.exception;

import lombok.Data;

@Data
public class ErrorObject {

	private String message;
	private String field;
	private Object parameter;
}

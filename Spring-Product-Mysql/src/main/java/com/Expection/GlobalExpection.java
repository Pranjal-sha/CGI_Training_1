package com.Expection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpection {
	
	@ExceptionHandler(ProductConditionException.class)
	public ResponseEntity<String> productExceptionHandler(ProductConditionException exp){
		return ResponseEntity.status(500).body("Custom product exception generated "+exp);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> genericExceptionHandler(Exception exp){
		return ResponseEntity.status(500).body("Generic Exception generated "+exp);
	}

}

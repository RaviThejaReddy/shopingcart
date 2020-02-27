package com.product.root.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.root.exception.GeneralException;

@ControllerAdvice
public class GeneralExceptionHandler extends RuntimeException {

    
	private static final long serialVersionUID = 1L;

	@ExceptionHandler
    public String HandelGeneralException(GeneralException ge){
        return ge.getMessage();
    }
}

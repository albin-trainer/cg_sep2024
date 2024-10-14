package com.cg.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.exceptions.ApplicationException;
//Catch block for entire App
@RestControllerAdvice //handling the exception
public class GlobalExceptionHandler {
	@ExceptionHandler({ApplicationException.class,Exception.class})
	public  ResponseEntity<String> handle(Exception e) {
		return   new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}

package com.cg.bankapp.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<String> handelCustomerNotFoundException(CustomerDetailsNotFoundException e){
			return new ResponseEntity<String> (e.getMessage() , HttpStatus.NOT_FOUND);	
		}
}

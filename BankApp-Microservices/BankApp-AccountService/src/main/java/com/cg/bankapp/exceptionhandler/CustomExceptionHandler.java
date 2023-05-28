package com.cg.bankapp.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;

@ControllerAdvice
public class CustomExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<String> handelAccountNotFoundException(AccountDetailsNotFoundException e){
			return new ResponseEntity<String> (e.getMessage() , HttpStatus.NOT_FOUND);	
		}
		
		@ExceptionHandler
		public ResponseEntity<String> handelInsufficientBalanceException(InsufficientBalanceException e){
			return new ResponseEntity<String> (e.getMessage() , HttpStatus.UNPROCESSABLE_ENTITY); // need to check appropriate status code 
		}
		@ExceptionHandler
		public ResponseEntity<String> handelNegativeAmounException(NegativeAmounException e){
			return new ResponseEntity<String> (e.getMessage() , HttpStatus.UNPROCESSABLE_ENTITY); // need to check appropriate status code 
		}
}

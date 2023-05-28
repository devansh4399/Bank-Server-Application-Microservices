package com.cg.bankapp.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.entities.Account;
import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;
import com.cg.bankapp.services.AccountServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController

public class AccountController {
	
	@Autowired private AccountServices accountServices;
	
	@PostMapping (value = "/addAccountDetails" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccountDetails(@RequestBody Account account){
		return new ResponseEntity<Account>(accountServices.addAccountDetails(account),HttpStatus.OK);
	}
	
	@PostMapping(value =  "/withdrawAmount")
	@CircuitBreaker(name="TransactionBreaker",fallbackMethod="transactionFallBack")
	public ResponseEntity<Double> withdrawAmount(@RequestParam int accountNo , @RequestParam double amount) throws AccountDetailsNotFoundException, InsufficientBalanceException, NegativeAmounException{
		return new ResponseEntity<Double> (accountServices.withdrawAmount(accountNo, amount),HttpStatus.OK);
	}
	
	@PostMapping(value =  "/depositAmount")
	@CircuitBreaker(name="TransactionBreaker",fallbackMethod="transactionFallBack")
	public ResponseEntity<Double> depositAmount(@RequestParam int accountNo , @RequestParam double amount) throws AccountDetailsNotFoundException, InsufficientBalanceException, NegativeAmounException{
		return new ResponseEntity<Double> (accountServices.depositAmount(accountNo, amount),HttpStatus.OK);
	}
	
	@PostMapping(value =  "/fundTransfer")
	@CircuitBreaker(name="TransactionBreaker",fallbackMethod="transactionFallBackTransfer")
	public ResponseEntity<Double> fundTransfer(@RequestParam int accountNoFrom,@RequestParam int accountNoTo ,@RequestParam int amount) throws AccountDetailsNotFoundException, InsufficientBalanceException, NegativeAmounException{
		return new ResponseEntity<Double>(accountServices.fundTransfer(accountNoFrom, accountNoTo, amount),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBalance")
	public ResponseEntity<Double> getBalance(@RequestParam int accountNo) throws AccountDetailsNotFoundException {
		return new ResponseEntity<Double> (accountServices.getBalance(accountNo),HttpStatus.OK);
	}
	
	//Creating method for circuit breaker
	
	 public ResponseEntity<String>transactionFallBack(int accountNo,double amount,Exception ex)
	 {
		 String message="Currently Transaction Service is down";
		 return new ResponseEntity<String>(message,HttpStatus.OK);
	 }
	 
	 public ResponseEntity<String>transactionFallBackTransfer(int accountNoFrom,int accountNoTo,int amount,Exception ex)
	 {
		 String message="Currently Transaction Service is down";
		 return new ResponseEntity<String>(message,HttpStatus.OK);
	 }
	
	 
	 
	
	
}

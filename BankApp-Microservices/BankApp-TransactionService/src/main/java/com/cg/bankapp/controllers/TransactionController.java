package com.cg.bankapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.entities.Transaction;
import com.cg.bankapp.services.TransactionService;

@RestController
public class TransactionController {

	@Autowired 
		private TransactionService transactionService ;

	@PostMapping(value = "/addTransactionDetails" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> addTransactionDetails(@RequestBody Transaction transaction){
		return new ResponseEntity<Transaction>( transactionService.addTransactionDetails(transaction),HttpStatus.OK);
	}
	@GetMapping(value={"/getAllTransactionsDetails/{accountNo}"})
	public ResponseEntity<List<Transaction>> getAllTransactionsDetails(@PathVariable int accountNo){
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactionsDetails(accountNo),HttpStatus.OK);
	}
}

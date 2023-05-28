package com.cg.bankapp.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp.daos.AccountDAO;
import com.cg.bankapp.dto.TransactionDTO;
import com.cg.bankapp.entities.Account;
import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AccountServicesImpl implements AccountServices{
	
	@Autowired private AccountDAO accountDAO;
	@Autowired private RestTemplate restTemplate;

	@Override
	public Account addAccountDetails(Account account) {
		
		return accountDAO.save(account);
		
	}

	@Override
	public Account getAccountDetails(int accountNo) throws AccountDetailsNotFoundException {
		return accountDAO.findById(accountNo).orElseThrow(()->new AccountDetailsNotFoundException("Account Details Not found for accountNo :- "+accountNo));
	}

	@Override
	public double withdrawAmount(int accountNo, double amount)
			throws AccountDetailsNotFoundException, InsufficientBalanceException, NegativeAmounException {
		Account account = getAccountDetails(accountNo);	
		account.setBalance(account.getBalance()-amount);
		accountDAO.save(account);
		addTransaction(new TransactionDTO(0,LocalDateTime.now(),"Debit",amount,account.getBalance(),accountNo));
		return account.getBalance();
	}

	@Override
	public double depositAmount(int accountNo, double amount)
			throws AccountDetailsNotFoundException,NegativeAmounException {
		Account account = getAccountDetails(accountNo);	
		account.setBalance(account.getBalance()+amount);
		accountDAO.save(account);
		addTransaction(new TransactionDTO(0,LocalDateTime.now(),"Credit",amount,account.getBalance(),accountNo));
		return account.getBalance();
	}

	@Override
	public double fundTransfer(int accountNoFrom, int accountNoTo, double amount)
			throws AccountDetailsNotFoundException, InsufficientBalanceException, NegativeAmounException {
		
		double balance= withdrawAmount(accountNoFrom, amount);
		depositAmount(accountNoTo, amount);
		
		return balance;
	}

	@Override
	public double getBalance(int accountNo) throws AccountDetailsNotFoundException {
		return getAccountDetails(accountNo).getBalance();
	}
	private void addTransaction(TransactionDTO transactionDTO) {
		try{	
			String uriEndPoint = "http://BANKAPP-TRANSACTIONSERVICE/transaction/addTransactionDetails";
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.findAndRegisterModules();
			String jsonData = objectMapper.writeValueAsString(transactionDTO);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, headers);

			restTemplate.postForObject(uriEndPoint, httpEntity, TransactionDTO.class);
	}catch(JsonProcessingException e) {
			System.out.println(e);
		}

	}
}

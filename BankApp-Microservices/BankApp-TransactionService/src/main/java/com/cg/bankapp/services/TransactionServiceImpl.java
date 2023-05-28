package com.cg.bankapp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.daos.TransactionDAO;
import com.cg.bankapp.entities.Transaction;

@Component
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired 
	private TransactionDAO transactionDAO ;

	@Override
	public Transaction addTransactionDetails(Transaction transaction) {
		return transactionDAO.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactionsDetails(int accountNo) {
		return transactionDAO.findByaccountNo(accountNo);
	}
	
}
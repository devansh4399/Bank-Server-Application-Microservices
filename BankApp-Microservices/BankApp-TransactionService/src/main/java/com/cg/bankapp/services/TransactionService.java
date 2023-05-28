package com.cg.bankapp.services;

import java.util.List;

import com.cg.bankapp.entities.Transaction;

public interface TransactionService {
	Transaction addTransactionDetails (Transaction transaction);
	List<Transaction> getAllTransactionsDetails(int accountNo);
}

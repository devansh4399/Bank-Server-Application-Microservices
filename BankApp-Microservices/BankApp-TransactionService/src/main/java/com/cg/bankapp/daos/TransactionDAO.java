package com.cg.bankapp.daos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.entities.Transaction;
public interface TransactionDAO extends JpaRepository<Transaction, Integer>{
	List<Transaction> findByaccountNo(int accountNo);
}
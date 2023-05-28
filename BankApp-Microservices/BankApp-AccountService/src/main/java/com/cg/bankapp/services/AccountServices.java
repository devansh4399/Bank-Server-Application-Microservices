package com.cg.bankapp.services;
import com.cg.bankapp.entities.Account;
import com.cg.bankapp.exceptions.AccountDetailsNotFoundException;
import com.cg.bankapp.exceptions.InsufficientBalanceException;
import com.cg.bankapp.exceptions.NegativeAmounException;
public interface AccountServices {
	public Account addAccountDetails(Account account);
	public Account getAccountDetails(int accountNo)throws AccountDetailsNotFoundException;
	public double withdrawAmount(int accountNo , double amount)throws AccountDetailsNotFoundException , InsufficientBalanceException , NegativeAmounException;
	public double depositAmount(int accountNo , double amount)throws AccountDetailsNotFoundException ,NegativeAmounException ;
	public double fundTransfer(int accountNoFrom , int accountNoTo , double amount) throws AccountDetailsNotFoundException , InsufficientBalanceException , NegativeAmounException;
	public double getBalance (int accountNo) throws AccountDetailsNotFoundException;
}

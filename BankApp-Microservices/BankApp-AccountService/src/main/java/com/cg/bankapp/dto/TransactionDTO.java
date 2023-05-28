package com.cg.bankapp.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
private int transactionId;
private LocalDateTime date;
private String type;
private double amount;
private double balance;
private int accountNo;
public TransactionDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getAccountNo() {
	return accountNo;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}
public TransactionDTO(int transactionId, LocalDateTime date, String type, double amount, double balance,
		int accountNo) {
	super();
	this.transactionId = transactionId;
	this.date = date;
	this.type = type;
	this.amount = amount;
	this.balance = balance;
	this.accountNo = accountNo;
}
@Override
public String toString() {
	return "TransactionDTO [transactionId=" + transactionId + ", date=" + date + ", type=" + type + ", amount=" + amount
			+ ", balance=" + balance + ", accountNo=" + accountNo + "]";
}

}

package com.cg.bankapp.entities;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;	
	
	@Column(name="transaction_date")
	private LocalDateTime date;	
	@Column(name="transaction_type")
	private String type;	
	@Column(name="transaction_amount")
	private double amount;	
	private double balance;
	@Column(name="account_No")
	private int accountNo;
	
	
	
	
}
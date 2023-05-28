package com.cg.bankapp.daos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.entities.Customer;
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	

}
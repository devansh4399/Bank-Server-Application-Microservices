package com.cg.bankapp.services;

import com.cg.bankapp.entities.Customer;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
public interface CustomerService {
	Customer addCustomerDetails(Customer customer);
	Customer getCustomerDetails (int  id) throws CustomerDetailsNotFoundException;
}
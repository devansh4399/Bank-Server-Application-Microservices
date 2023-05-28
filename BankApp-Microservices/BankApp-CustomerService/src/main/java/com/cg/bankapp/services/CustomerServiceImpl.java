package com.cg.bankapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.bankapp.daos.CustomerDAO;
import com.cg.bankapp.entities.Customer;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;

@Component
public class CustomerServiceImpl implements CustomerService{
	
		@Autowired CustomerDAO customerDAO;

		@Override
		public Customer addCustomerDetails(Customer customer) {
			return customerDAO.save(customer);
		}
		
		@Override
		public Customer getCustomerDetails(int id) throws CustomerDetailsNotFoundException {
			return customerDAO.findById(id).orElseThrow(()-> new CustomerDetailsNotFoundException("Customer Details not found for id :- "+id));
		}
	
}
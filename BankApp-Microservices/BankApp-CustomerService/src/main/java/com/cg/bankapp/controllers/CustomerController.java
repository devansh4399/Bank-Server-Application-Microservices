package com.cg.bankapp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.entities.Customer;
import com.cg.bankapp.exceptions.CustomerDetailsNotFoundException;
import com.cg.bankapp.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired private CustomerService service; 
	
	@PostMapping (value = "/addCustomerDetails" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomerDetails(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(service.addCustomerDetails(customer),HttpStatus.OK) ;
	}
	
	@GetMapping(value = {"/getCustomerDetails/{id}" })
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable int id) throws CustomerDetailsNotFoundException {
		return new ResponseEntity<Customer>(service.getCustomerDetails(id),HttpStatus.OK) ;
	}

}
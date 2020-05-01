package com.assignment.salesorder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.exception.CustomerException;

@Service
public interface CustomerService {

	//get all customers
	List<Customer> getAllCustomers();
	Customer saveCustomer(Customer customer);
	Customer getCustomer(Integer id) throws CustomerException;
	
	void deleteCustomer(Integer id) throws CustomerException;
	Customer updateCustomer(Integer id) throws CustomerException;
}


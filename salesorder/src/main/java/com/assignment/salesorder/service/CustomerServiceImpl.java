package com.assignment.salesorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.exception.CustomerException;
import com.assignment.salesorder.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository custRepo;
	
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> allCustomers = custRepo.findAll();
		return allCustomers;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer savedCustomer = custRepo.saveAndFlush(customer);
		return savedCustomer;
	}
	
	@Override
	public Customer getCustomer(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> custOpt = custRepo.findById(id);
		
		  if (!(custOpt.isPresent()) || custOpt.get().getCustomerId() <=0) {
		  
		  throw new CustomerException("Customer does not exist!"); 
		  }
		 
		
		return custOpt.get();
	}
	
	@Override
	public void deleteCustomer(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		/*
		 * Optional<Customer> customer = custRepo.findById(id); if (customer.get() ==
		 * null || customer.get().getCustomerId() <=0) {
		 * 
		 * throw new CustomerException("Customer does not exist!"); }
		 * 
		 * custRepo.delete(customer.get());
		 */
		custRepo.deleteById(id);
	}

	@Override
	public Customer updateCustomer(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = custRepo.findById(id);
		
		if (!(customer.isPresent()) || customer.get().getCustomerId() <=0) {
			
			throw new CustomerException("Customer does not exist!");
		}
		
		customer.get().setName("NewName");
		custRepo.saveAndFlush(customer.get());
		return customer.get();
	}
}

package com.assignment.salesorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.exception.CustomerException;
import com.assignment.salesorder.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	//private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	

	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() throws CustomerException{
		
		//logger.info("Returning all Customers!!!");
		return  customerService.getAllCustomers();
		//return listOfCustomers;
	}
	
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer cust) {
		//logger.info("Save a Customer!!!");
		cust = customerService.saveCustomer(cust);
		return cust;
	}

	/*
	 * @GetMapping("/show/{id}") public Customer getCustomer(@PathVariable("id")
	 * Integer id) throws CustomerException {
	 * 
	 * //logger.info("Getting a Customer!!!"); Customer customer =
	 * customerService.getCustomer(id);
	 * 
	 * if(customer == null || customer.getCustomerId() <=0) { throw new
	 * CustomerException("Customer doesn't exist!"); } return customer;
	 * 
	 * }
	 */
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) throws CustomerException {
		

		return new ResponseEntity<>(customerService.getCustomer(id),HttpStatus.OK);

	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Integer id) throws CustomerException{
		customerService.deleteCustomer(id);
	}
	
	
	
	@PutMapping("update/{id}")
	public Customer updateCustomer(@PathVariable("id") Integer id) throws CustomerException{
		
		//logger.info("Updating Customer!!!");
		return customerService.updateCustomer(id);
	}
	
}

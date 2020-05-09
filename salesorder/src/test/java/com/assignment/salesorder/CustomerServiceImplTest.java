package com.assignment.salesorder;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assignment.salesorder.entity.Address;
import com.assignment.salesorder.entity.Customer;
import com.assignment.salesorder.exception.CustomerException;
import com.assignment.salesorder.repo.CustomerRepository;
import com.assignment.salesorder.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Stream
				.of(new Customer(55, "DumyUser", "dummy@mail.com", new Address(88, "Wakad", "Pune", 411057)),
						new Customer(56, "Dumy2User", "dummy2@mail.com", new Address(89, "Baner", "Pune", 411254)))
				.collect(Collectors.toList()));

		// Comparing size
		assertEquals(2, customerService.getAllCustomers().size());
	}

	
	
	@Test
	public void getCustomerTest() throws CustomerException {
		Integer customerId = 100;
		Customer customer = new Customer(100, "DumyUser", "dummy@mail.com", new Address(88, "Wakad", "Pune", 411057));
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
				

				
		 assertEquals(100, customerService.getCustomer(customerId).getCustomerId());
		//assertThat(customerService.getCustomer(customerId).getCustomerId().equals(100));
		//Optional<Customer> custById = customerRepository.findById(customerId);
		//assertTrue(custById != null);
	}
	 
	@Test
	public void getCustomerFailTest() throws CustomerException {
		Integer customerId = 50;
		Customer customer = new Customer(100, "DumyUser", "dummy@mail.com", new Address(88, "Wakad", "Pune", 411057));
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
				

				
		 assertNotEquals(customerId, customerService.getCustomer(customerId).getCustomerId());
		//assertThat(customerService.getCustomer(customerId).getCustomerId().equals(100));
		//Optional<Customer> custById = customerRepository.findById(customerId);
		//assertTrue(custById != null);
	}

	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer(55, "DumyUser", "dummy@mail.com", new Address(88, "Wakad", "Pune", 411057));
		when(customerRepository.saveAndFlush(customer)).thenReturn(customer);

		assertEquals(customer, customerService.saveCustomer(customer));
	}



	@Test
	public void deleteCustomerTest() throws CustomerException {
		Customer customer = new Customer(55,"DumyUser", "dummy@mail.com", new Address(88,"Wakad","Pune",411057));
		customerService.deleteCustomer(customer.getCustomerId());
		verify(customerRepository, times(1)).deleteById(customer.getCustomerId());
		
	}
	
	
	@Test
	public void updateCustomerTest() throws CustomerException {
		Integer customerId = 100;
		String changedName = "NewName";
		Customer customer = new Customer(55,"newName", "dummy@mail.com", new Address(88,"Wakad","Pune",411057));
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
	
		 assertEquals(changedName, customerService.updateCustomer(customerId).getName());
	}
	
	
	/*
	 * @Test public void updateCustomerFailTest() throws CustomerException { Integer
	 * customerId = 100;
	 * 
	 * Mockito.doThrow(new
	 * CustomerException("Customer does not exist!")).when(customerRepository.
	 * findById(customerId)); }
	 */
}

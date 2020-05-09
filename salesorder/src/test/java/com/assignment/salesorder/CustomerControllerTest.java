package com.assignment.salesorder;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.salesorder.entity.Address;
import com.assignment.salesorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// interaction with controller 
	@Autowired
	private WebApplicationContext context;
	
	// object to JSON string;
	//private ObjectMapper objMapper = new ObjectMapper();
	
	//intialize mockMVC before loading class, so that get,post etc methods can be performed
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
		
		
	@Test
	public void getAllCustomers() throws Exception {

		/*
		 * mockMvc.perform(MockMvcRequestBuilders.get("/customers/getAll")
		 * .accept(org.springframework.http.MediaType.APPLICATION_JSON)).andDo(print()).
		 * andExpect(status().isOk())
		 * .andExpect(MockMvcResultMatchers.jsonPath("$.customer").exists())
		 * .andExpect(MockMvcResultMatchers.jsonPath("$.customer[*].customerId").
		 * isNotEmpty());
		 */
		
		String uri = "/customers/getAll";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		/*
		 * String content = mvcResult.getResponse().getContentAsString(); Customer[]
		 * allCustomers = super.mapFromJson(content, Customer[].class);
		 * assertTrue(allCustomers.length > 0);
		 */
		//assertTrue(allCustomers.length > 0);
	}
		 
		 
	
	@Test
	public void getCustomerById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/show/{id}", 2)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(2));
	}

	@Test
	public void saveCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/customers")
				.content(asJsonString(
						new Customer(55, "NewUser", "new@mail.com", new Address(88, "Wakad", "Pune", 411057))))
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void updateCustomerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/customers/update/{id}", 14)
				.content(asJsonString(
						new Customer(14, "NewName", "dummy@mail.com", new Address(88, "Wakad", "Pune", 411057))))
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("NewName"));
	}

	@Test
	public void deleteCustomerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/customers/delete/{id}", 33)).andExpect(status().isOk());
	}
	 
}

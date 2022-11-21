package com.customer.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.customer.domains.Customer;
import com.customer.dtos.CustomerDto;
import com.customer.repositories.CustomerRepository;

class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerRepository customerRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void testSaveCustomer() {
		
	}

	@Test
	void testGetCustomers() {
		
	}

	@Test
	void testGetCustomerById() {
	}

	@Test
	void testUpdateCustomer() {
	}

	@Test
	void testDeleteCustomer() {
	}

}

package com.customer.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.dtos.CustomerDto;
import com.customer.services.CustomerService;

@SpringBootTest
class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;

	@Test
	void testSaveCustomer() {
		CustomerDto customerDto = new CustomerDto(1L, "Suraj", "suraj@gmail.com", "9876543211");
		customerController.saveCustomer(customerDto);
	}

	@Test
	void testGetCustomers() {
		customerController.getCustomers();
	}

	@Test
	void testGetCustomersLong() {
		customerController.getCustomers(0L);
	}

	@Test
	void testUpdateCustomer() {
		CustomerDto customerDto = new CustomerDto(1L, "Suraj", "suraj@gmail.com", "9876543211");
		customerController.updateCustomer(customerDto, 1L);
	}

	@Test
	void testDeleteCustomer() {
		customerController.deleteCustomer(1L);
	}

}

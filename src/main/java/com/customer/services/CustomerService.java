package com.customer.services;

import java.util.List;

import com.customer.dtos.CustomerDto;

public interface CustomerService {
	
	CustomerDto saveCustomer(CustomerDto customerDto);
	
	List<CustomerDto> getCustomers();
	
	CustomerDto getCustomerById(Long CustomerId);
	
	CustomerDto updateCustomer(CustomerDto customerDto,Long CustomerId);
	
	void deleteCustomer(Long CustomerId);

}

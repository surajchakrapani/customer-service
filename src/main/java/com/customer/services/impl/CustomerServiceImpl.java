package com.customer.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.domains.Customer;
import com.customer.dtos.CustomerDto;
import com.customer.exceptions.ResourceNotFoundException;
import com.customer.repositories.CustomerRepository;
import com.customer.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Customer savedCustomer = customerRepository.save(customer);
		CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);
		return savedCustomerDto;
	}

	@Override
	public List<CustomerDto> getCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		customerList.stream().forEach((customer)->{
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		customerDtoList.add(customerDto);
		});
		return customerDtoList;
	}

	@Override
	public CustomerDto getCustomerById(Long CustomerId) {
		Customer customer = customerRepository.findById(CustomerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", CustomerId));
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto,Long CustomerId) {
		Customer customer = customerRepository.findById(CustomerId).orElseThrow(()-> new ResourceNotFoundException("Customer", "Id", CustomerId));
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		Customer updatedCustomer = customerRepository.save(customer);
		CustomerDto updateCustomerDto = modelMapper.map(updatedCustomer, CustomerDto.class);
		return updateCustomerDto;
	}

	@Override
	public void deleteCustomer(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
		customerRepository.delete(customer);
	}

}

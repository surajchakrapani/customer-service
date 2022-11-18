package com.customer.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.customer.dtos.ApiResponse;
import com.customer.dtos.CustomerDto;
import com.customer.services.CustomerService;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto customerDto){
		CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
		return new ResponseEntity<>(savedCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CustomerDto>> getCustomers(){
		return ResponseEntity.ok(customerService.getCustomers());
	}
	
	@GetMapping("/get/{customerId}")
	public ResponseEntity<CustomerDto> getCustomers(@PathVariable("customerId") Long customerId){
		return ResponseEntity.ok(customerService.getCustomerById(customerId));
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId){
		CustomerDto updatedUser = customerService.updateCustomer(customerDto, customerId);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("customerId") Long customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer deleted Successfully",true),HttpStatus.OK);
	}
	
}

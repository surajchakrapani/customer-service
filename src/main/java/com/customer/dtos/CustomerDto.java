package com.customer.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private Long customerId;
	
	@NotEmpty
	@Size(min = 4, message = "UserName must be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid!!")
	private String email;
	
	@NotBlank(message = "mobileNumber is required")
	@Size(min = 10, max = 10)
	private String mobileNumber;

}

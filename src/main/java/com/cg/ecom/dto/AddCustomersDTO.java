package com.cg.ecom.dto;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomersDTO 
{

	@NotNull(message = "Customer name is required")
	@Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
	private String customerName;

	@NotNull(message = "Address is required")
	private String address;

	@NotNull(message = "Mobile number is required")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
	private Long mobilenumber;

	@NotNull(message = "Email ID is required")
	@Email(message = "Email ID should be valid")
	private String emailId;

}

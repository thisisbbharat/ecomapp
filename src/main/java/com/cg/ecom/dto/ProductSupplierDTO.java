package com.cg.ecom.dto;

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
public class ProductSupplierDTO {
	
	
	@NotNull(message = "productSupplier ID cannot be null")
	private int productSupplierId;
	
	@NotNull(message = "productSupplierName is required")
	@Size(min = 3, max = 50, message = "productSupplierName must be between 3 and 50 characters")
	private String productSupplierName;
	
	@NotNull(message = "location is required")
	private String location;
	
	@NotNull(message = "Mobile number is required")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
	private Long contactNo;
	
	@NotNull(message = "Email ID is required")
	@Email(message = "Email ID should be valid")
	private String emailId;
//	private String username;
//	private String password;
//	private int userId;


}

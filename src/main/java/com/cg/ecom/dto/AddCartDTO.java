package com.cg.ecom.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCartDTO 
{
	@NotNull(message = "productId cannot be null")
	private int productId;
	
	
	@NotNull(message = "Customer ID cannot be null")
	private int customerId;
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity should be greater than or equal to 1")
	private int quantity;
	

}

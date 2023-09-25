package com.cg.ecom.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemsDTO {
	
	
	@NotNull(message = "product ID cannot be null")
	private int productId;
	
	@NotNull(message = "product name is required")
	@Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
	private String ProductName;
	
	@NotNull(message = "Price should be mandatory")
	private int price;
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity should be greater than or equal to 1")
	private int quantity;
	///////////
	
	@NotNull(message = "productSupplier Id cannot be null")
	private int productSupplierId;



	
}

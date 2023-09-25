package com.cg.ecom.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

	@NotNull(message = "Cart ID cannot be null")
	private Integer cartId;

	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;

	@NotNull(message = "Customer ID cannot be null")
	private Integer customerId;

	@NotNull(message = "Product ID cannot be null")
	private Integer productId;

	// getters and setters
}

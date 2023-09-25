package com.cg.ecom.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
	
	
	@NotNull(message = "Cart ID cannot be null")
	private int orderId;
	//private LocalDate date;
	
	@NotNull(message = "Status must be displayed")
	private String status;
	
	@NotNull(message = "Address must be required")
	private String deliveryAddress;
	/////////////////
	
	
	@NotNull(message = "Customer ID cannot be null")
	private int customerId;
	
	@NotNull(message = "productSupplier ID cannot be null")
	private int productSupplierId;
	
	@NotNull(message = "Cart ID cannot be null")
	private int cartId;
//	private int productId;
//	private int quantity;
	


	

}

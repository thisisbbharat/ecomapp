package com.cg.ecom.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrdersDTO {

    @NotNull(message = "Status must be displayed")
	private String status;

    @NotNull(message = "Address should be mandatory")
	private String deliveryAddress;
    
    @NotNull(message = "Customer Id cannot be null")
    private int customerId;
    
    @NotNull(message = "productSupplier Id cannot be null")
	private int productSupplierId;
    
    @NotNull(message = "Cart Id cannot be null")
	private int cartId;
    
    @NotNull(message = "Product Id cannot be null")
	private int productId;
//	private int quantity;
	


	

}
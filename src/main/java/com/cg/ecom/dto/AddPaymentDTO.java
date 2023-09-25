package com.cg.ecom.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddPaymentDTO {

    @NotNull(message = "payment date is required")
	private LocalDate paymentDate;
    
    @NotNull(message = "mandatory to display payment type")
	private String paymentType;
    
    @NotNull(message = "mandatory to display payment status")
	private String paymentStatus;
	///////////
    
    @NotNull(message = "Cart Id cannot be null")
	private int cartId;
    
    @NotNull(message = "Order Id cannot be null")
	private int orderId;
    
    @NotNull(message = "product Id cannot be null")
	private int productId;
    
    @NotNull(message = "Customer Id cannot be null")
	private int customerId;
}

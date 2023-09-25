package com.cg.ecom.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
	
	
	@NotNull(message = "Payment ID cannot be null")
	private int paymentId;
	
	@NotNull(message = "mandatory to display payment date")
	private LocalDate paymentDate;
	
	@NotNull(message = "mandatory to display payment type")
	private String paymentType;
	
	@NotNull(message = "mandatory to display payment status")
	private String paymentStatus;
	
	@NotNull(message = "total price must be displayed")
	private long totalPrice;
	///////////
//	private int cartId;
	
	@NotNull(message = "order ID cannot be null")
	private int orderId;
	
	@NotNull(message = "customer ID cannot be null")
	private int customerId;
	


}

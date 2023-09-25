package com.cg.ecom.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_details")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;

	@NotNull(message = "Payment date is required")
	private LocalDate paymentDate;

	@NotBlank(message = "Payment type is required")
	private String paymentType;

	@NotBlank(message = "Payment status is required")
	private String paymentStatus;

	@NotNull(message = "Total price is required")
	@Positive(message = "Total price must be positive")
	private long totalPrice;
    
	@NotNull(message = "Order is required")
	@OneToOne
	@JoinColumn(name="payment_order_fk")
	private Orders orderId;

	@NotNull(message = "Customer is required")
	@ManyToOne
	@JoinColumn(name="payment_customer_fk")
	private Customers customerId;
	
	// constructors, getters and setters
}


//@Transient
//@OneToOne
//@JoinColumn(name="payment_cart_fk")
//private Cart cartId;

//@OneToMany(cascade = CascadeType.ALL)
//@JoinColumn(name="payment_product_fk")
//private List<ProductItems> productItems ;

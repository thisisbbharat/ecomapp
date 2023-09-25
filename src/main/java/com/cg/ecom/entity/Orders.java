package com.cg.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@NotBlank(message = "Status is required")
	private String status;

	@NotBlank(message = "Delivery address is required")
	private String deliveryAddress;

	@NotNull(message = "Customer is required")
	@ManyToOne
	@JoinColumn(name = "customer_order_fk")
	private Customers customerId;

	@NotNull(message = "Product supplier is required")
	@ManyToOne
	@JoinColumn(name = "productsup_fk")
	private ProductSupplier productSupplierId;

	@NotNull(message = "Cart is required")
	@ManyToOne
	@JoinColumn(name = "Order_cart_fk")
	private Cart cartId;

	@OneToOne(mappedBy = "orderId")
	private Payment payment;

	// getters and setters
}


//private LocalDate date;
//private int cartId;

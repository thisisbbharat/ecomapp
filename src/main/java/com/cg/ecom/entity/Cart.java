package com.cg.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_details")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

//	@NotNull(message = "Quantity cannot be null")
//	@Min(value = 1, message = "Quantity should be greater than or equal to 1")
	private int quantity;

//	@NotNull(message = "Customer cannot be null")
	@OneToOne
	@JoinColumn(name = "customer_cart_fk")
	private Customers customers;

//	@NotNull(message = "Product item cannot be null")
	@OneToOne
	@JoinColumn(name = "cart_product_fk")
	private ProductItems productItems;

}

	
//	@Transient	
//	private List<ProductItems> productItems;
	
//	@OneToMany
//	@JoinColumn(name = "cart_product_fk")
//	private List<ProductItems> productItems;
	
	
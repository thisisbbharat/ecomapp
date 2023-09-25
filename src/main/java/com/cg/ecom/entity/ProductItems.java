package com.cg.ecom.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_items")
public class ProductItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;	
	
	@NotBlank(message = "Product name is required")
	private String productName;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be positive")
	private int price;

	@NotNull(message = "Quantity is required")
	@PositiveOrZero(message = "Quantity must be non-negative")
	private int quantity;

	@NotNull(message = "Product supplier is required")
	@ManyToOne
	@JoinColumn(name = "product_supplier_id")
	private ProductSupplier productSuppliers;

	@Transient
	private Cart carts;

	// constructors, getters and setters
}



//@Transient
//private Cart carts;

// constructors, getters, and setters omitted
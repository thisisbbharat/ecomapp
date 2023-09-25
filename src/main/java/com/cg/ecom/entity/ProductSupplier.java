package com.cg.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_suppplier")
public class ProductSupplier {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productSupplierId;
	
	@NotBlank(message = "Product supplier name is required")
	private String productSupplierName;

	@NotBlank(message = "Location is required")
	private String location;

	@NotNull(message = "Contact number is required")
	@Digits(integer = 10, fraction = 0, message = "Contact number must be a valid 10-digit number")
	private Long contactNo;

	@NotBlank(message = "Email ID is required")
	@Email(message = "Email ID must be a valid email address")
	private String emailId;

	// constructors, getters and setters
}


//@OneToOne
//@JoinColumn(name = "userId")
//private User userId;
package com.cg.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_details")
public class Customers {

	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
//	@Column(name = "customerName", nullable = false)
//	@NotNull(message = "Customer name is required")
//	@Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
	private String customerName;

	//@NotNull(message = "Address is required")
	private String address;

//	@NotNull(message = "Mobile number is required")
//	@Digits(integer = 10, fraction = 0, message = "Mobile number must be 10 digits")
	private Long mobilenumber;

//	@NotNull(message = "Email ID is required")
//	@Email(message = "Email ID should be valid")
	private String emailId;

}


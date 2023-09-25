package com.cg.ecom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecom.dto.AddCustomersDTO;
import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.service.CustomersService;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	@Autowired
	public CustomersService customersService;

	

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomersnew(@Valid @RequestBody AddCustomersDTO customers, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    CustomersDTO savecustomer = customersService.addCustomers(customers);
	    return ResponseEntity.ok(savecustomer);
	}

	
	
	@PutMapping("/updateCustomers")
	public ResponseEntity<?> updateCustomers(@Valid @RequestBody CustomersDTO customersDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    CustomersDTO updatedCustomer = customersService.updateCustomers(customersDTO);
	    return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/deleteCustomers/{id}")
	public ResponseEntity<?> deleteCustomersById(@PathVariable int id) {
	    CustomersDTO customersDTO = customersService.getById(id);
	    if (customersDTO != null) {
	        customersService.deleteCustomers(customersDTO);
	        return ResponseEntity.ok(true);
	    }
	    throw new ItemNotAvailableException("Customers with id " + id + " does not exist");
	}

///////////////
	
	
	
}

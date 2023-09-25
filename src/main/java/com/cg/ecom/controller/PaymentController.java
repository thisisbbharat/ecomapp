package com.cg.ecom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecom.dto.AddPaymentDTO;
import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.exceptions.PaymentNotFoundException;
import com.cg.ecom.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	public PaymentService paymentService;

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody AddPaymentDTO addPaymentDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    PaymentDTO addedPayment = paymentService.addPayment(addPaymentDTO);
	    return ResponseEntity.ok(addedPayment);
	}

	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<?> deletePaymentById(@PathVariable int id) {
	    PaymentDTO paymentDTO = paymentService.getById(id);
	    if (paymentDTO != null) {
	        paymentService.deletePayment(paymentDTO);
	        return ResponseEntity.ok(true);
	    }
	    throw new PaymentNotFoundException("Payment with id " + id + " does not exist");
	}

	@GetMapping("/fetchPaymentById/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable int id) {
	    PaymentDTO paymentDTO = paymentService.getById(id);
	    if (paymentDTO != null) {
	        return ResponseEntity.ok(paymentDTO);
	    }
	    throw new PaymentNotFoundException("Payment with id " + id + " does not exist");
	}

	@GetMapping("/fetchAllPayments")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() {
	    List<PaymentDTO> list = paymentService.findAll();
	    return ResponseEntity.ok(list);
	}

}

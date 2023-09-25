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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecom.dto.AddCartDTO;
import com.cg.ecom.dto.CartDTO;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	public CartService cartService;
	
       @PostMapping("/addToCart")
	public ResponseEntity<?> addToCart(@Valid @RequestBody AddCartDTO addCartDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    CartDTO cartDTO = cartService.addToCart(addCartDTO);
	    return ResponseEntity.ok(cartDTO);
	}
	
	@PutMapping("/updateCart")
	public ResponseEntity<?> updateCart(@Valid @RequestBody CartDTO cartDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    CartDTO updatedCart = cartService.updateCart(cartDTO);
	    return ResponseEntity.ok(updatedCart);
	}

	@GetMapping("/getCartById/{id}")
	public ResponseEntity<?> getCartById(@PathVariable int id) {
	    CartDTO cartDTO = cartService.getById(id);
	    if (cartDTO != null) {
	        return ResponseEntity.ok(cartDTO);
	    }
	    throw new ItemNotAvailableException("Cart with id " + id + " doesn't exist");
	}

	@DeleteMapping("/deleteCartById/{id}")
	public ResponseEntity<?> deleteCartById(@PathVariable int id) {
	    CartDTO cartDTO = cartService.getById(id);
	    if (cartDTO != null) {
	        cartService.deleteCart(cartDTO);
	        return ResponseEntity.ok(true);
	    }
	    throw new ItemNotAvailableException("Cart with id " + id + " doesn't exist");
	}

	@GetMapping("/fetchAllinCart")
	public ResponseEntity<List<CartDTO>> getAll() {
	    List<CartDTO> list = cartService.findAll();
	    return ResponseEntity.ok(list);
	}


	
}

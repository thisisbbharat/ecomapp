package com.cg.ecom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.cg.ecom.dto.AddOrdersDTO;
import com.cg.ecom.dto.OrdersDTO;
import com.cg.ecom.entity.Orders;
import com.cg.ecom.exceptions.CartIdAlreadyExistsException;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.repository.OrdersRepository;
import com.cg.ecom.service.OrdersService;


@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	public OrdersService ordersService;
	
	@Autowired
	public OrdersRepository ordersRepository;
	
	@PostMapping("/addOrders")
	public ResponseEntity<?> addOrders(@Valid @RequestBody AddOrdersDTO addOrdersDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    Optional<Orders> existingOrder = ordersRepository.findById(addOrdersDTO.getCartId());
	    if (!existingOrder.isPresent()) {
	        OrdersDTO orders = ordersService.addOrders(addOrdersDTO);
	        return ResponseEntity.ok(orders);
	    }

	    throw new CartIdAlreadyExistsException();
	}

	@GetMapping("/fetchOrderById/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable int id) {
	    OrdersDTO ordersDTO = ordersService.getById(id);

	    if (ordersDTO != null) {
	        return ResponseEntity.ok(ordersDTO);
	    }
	    throw new ItemNotAvailableException("Order with id " + id + " doesn't exist");
	}

	@PutMapping("/updateOrders")
	public ResponseEntity<?> updateOrders(@Valid @RequestBody OrdersDTO ordersDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    OrdersDTO updatedOrders = ordersService.updateOrders(ordersDTO);
	    return ResponseEntity.ok(updatedOrders);
	}

	@DeleteMapping("/deleteOrdersById/{id}")
	public ResponseEntity<?> deleteOrderById(@PathVariable int id) {
	    OrdersDTO ordersDTO = ordersService.getById(id);
	    if (ordersDTO != null) {
	        ordersService.deleteOrders(ordersDTO);
	        return ResponseEntity.ok(true);
	    }
	    throw new ItemNotAvailableException("Orders with id " + id + " doesn't exist");
	}

	@GetMapping("/fetchAllOrders")
	public ResponseEntity<List<OrdersDTO>> getAllOrders() {
	    List<OrdersDTO> list = ordersService.findAll();
	    return ResponseEntity.ok(list);
	}

}

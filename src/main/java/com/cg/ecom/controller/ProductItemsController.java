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

import com.cg.ecom.dto.AddProductItemsDTO;
import com.cg.ecom.dto.ProductItemsDTO;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.service.ProductItemsService;

@RestController
@RequestMapping("/api/product")
public class ProductItemsController {

	@Autowired
	public ProductItemsService productItemsService;
	
	@PostMapping("/addProductItems")
	public ResponseEntity<?> addProductItems(@Valid @RequestBody AddProductItemsDTO addProductItemsDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    ProductItemsDTO addedProductItems = productItemsService.addProductItems(addProductItemsDTO);
	    return ResponseEntity.ok(addedProductItems);
	}

	@GetMapping("/productItemsById/{id}")
	public ResponseEntity<?> getProductItemsById(@PathVariable int id) {
	    ProductItemsDTO productItemsDTO = productItemsService.getById(id);
	    if (productItemsDTO != null) {
	        return ResponseEntity.ok(productItemsDTO);
	    }
	    throw new ItemNotAvailableException("Product items with id " + id + " does not exist");
	}

	@PutMapping("/updateProductItems")
	public ResponseEntity<?> updateProductItems(@Valid @RequestBody ProductItemsDTO productItemsDTO, BindingResult result) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.badRequest().body(errors);
	    }

	    ProductItemsDTO updatedProductItems = productItemsService.updateProductItems(productItemsDTO);
	    return ResponseEntity.ok(updatedProductItems);
	}

	@DeleteMapping("/deleteProductItems/{id}")
	public ResponseEntity<?> deleteProductItemsById(@PathVariable int id) {
	    ProductItemsDTO productItemsDTO = productItemsService.getById(id);
	    if (productItemsDTO != null) {
	        productItemsService.deleteProductItems(productItemsDTO);
	        return ResponseEntity.ok(true);
	    }
	    throw new ItemNotAvailableException("Items with id " + id + " does not exist");
	}

	@GetMapping("/fetchAllProductItems")
	public ResponseEntity<List<ProductItemsDTO>> getAllProductItems() {
	    List<ProductItemsDTO> list = productItemsService.findAll();
	    return ResponseEntity.ok(list);
	}

}

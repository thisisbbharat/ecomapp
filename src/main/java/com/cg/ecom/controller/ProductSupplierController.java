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

import com.cg.ecom.dto.AddProductSupplierDTO;
import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.exceptions.CustomerNotFoundException;
import com.cg.ecom.exceptions.ProductSupplierNotAvailableException;
import com.cg.ecom.service.CustomersService;
import com.cg.ecom.service.ProductSupplierService;

@RestController
@RequestMapping("/api/ProductSuppliers")
public class ProductSupplierController {

	@Autowired
	public ProductSupplierService productSupplierService;

	@Autowired
	public CustomersService customersService;
	

/////////////
@GetMapping("/fetchCustomersById/{id}")
public ResponseEntity<CustomersDTO> getCustomersById(@PathVariable int id) 
{
	
CustomersDTO customersDTO = customersService.getById(id);
if(customersDTO != null) 
{

return new ResponseEntity<CustomersDTO>(customersDTO, HttpStatus.FOUND);
}
throw new CustomerNotFoundException();
}

@GetMapping("/fetchAllCustomers")
public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
List<CustomersDTO> list = customersService.findAll();
return ResponseEntity.ok(list);
}
//////////////
	
@PostMapping("/addProductSuppliers")
public ResponseEntity<?> addProductSuppliers(@Valid @RequestBody AddProductSupplierDTO addProductSupplierDTO, BindingResult result) {
    if (result.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    ProductSupplierDTO addedProductSupplier = productSupplierService.addProductSupplier(addProductSupplierDTO);
    return ResponseEntity.ok(addedProductSupplier);
}

@GetMapping("/fetchProductSuppliersById/{id}")
public ResponseEntity<?> getProductSupplierById(@PathVariable int id) {
    ProductSupplierDTO productSupplierDTO = productSupplierService.getById(id);
    if (productSupplierDTO != null) {
        return ResponseEntity.ok(productSupplierDTO);
    }
    throw new ProductSupplierNotAvailableException("ProductSupplier with id " + id + " does not exist");
}

@PutMapping("/updateProductSuppliers")
public ResponseEntity<?> updateProductSupplier(@Valid @RequestBody ProductSupplierDTO productSupplierDTO, BindingResult result) {
    if (result.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    ProductSupplierDTO updatedProductSupplier = productSupplierService.updateProductSupplier(productSupplierDTO);
    return ResponseEntity.ok(updatedProductSupplier);
}

@DeleteMapping("/deleteProductSuppliers/{id}")
public ResponseEntity<?> deleteProductSupplierById(@PathVariable int id) {
    ProductSupplierDTO productSupplierDTO = productSupplierService.getById(id);
    if (productSupplierDTO != null) {
        productSupplierService.deleteProductSupplier(productSupplierDTO);
        return ResponseEntity.ok(true);
    }
    throw new ProductSupplierNotAvailableException("ProductSupplier with id " + id + " does not exist");
}

@GetMapping("/fetchAllProductSuppliers")
public ResponseEntity<List<ProductSupplierDTO>> getAllProductSuppliers() {
    List<ProductSupplierDTO> list = productSupplierService.findAll();
    return ResponseEntity.ok(list);
}

}

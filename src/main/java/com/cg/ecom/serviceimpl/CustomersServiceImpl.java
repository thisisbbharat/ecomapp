package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.AddCustomersDTO;
import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.exceptions.CustomerNotFoundException;
import com.cg.ecom.repository.CustomersRepository;
import com.cg.ecom.service.CustomersService;



@Service
public class CustomersServiceImpl implements CustomersService {
	@Autowired
	private CustomersRepository customerRepository ;
	


	
/////////////
	
	@Override
	public CustomersDTO addCustomers(AddCustomersDTO addCustomersDTO) {

	    Customers customers = new Customers();

	    customers.setAddress(addCustomersDTO.getAddress());
	    customers.setEmailId(addCustomersDTO.getEmailId());
	    customers.setMobilenumber(addCustomersDTO.getMobilenumber());
	    customers.setCustomerName(addCustomersDTO.getCustomerName());

	    Customers savedCustomers = customerRepository.save(customers);

	    CustomersDTO customersDTO = new CustomersDTO();
	    customersDTO.setCustomerId(savedCustomers.getCustomerId());
	    customersDTO.setAddress(savedCustomers.getAddress());
	    customersDTO.setCustomerName(savedCustomers.getCustomerName());
	    customersDTO.setEmailId(savedCustomers.getEmailId());
	    customersDTO.setMobilenumber(savedCustomers.getMobilenumber());
	    
//	    ModelMapper modelMapper = new ModelMapper();
//	    CustomersDTO customersDTO = modelMapper.map( savedCustomers, CustomersDTO.class);

	    return customersDTO;
	}

	
	
	@Override
	public CustomersDTO updateCustomers(CustomersDTO customersDTO) {
	    Optional<Customers> optionalCustomer = customerRepository.findById(customersDTO.getCustomerId());
	    if (optionalCustomer.isPresent()) {
	        Customers customers = optionalCustomer.get();
	        customers.setAddress(customersDTO.getAddress());
	        customers.setEmailId(customersDTO.getEmailId());
	        customers.setMobilenumber(customersDTO.getMobilenumber());
	        customers.setCustomerName(customersDTO.getCustomerName());
	        Customers savedCustomer = customerRepository.save(customers);
	        
	       
	        customersDTO.setCustomerId(savedCustomer.getCustomerId());
	        return customersDTO;
	    } else {
	        throw new CustomerNotFoundException();
	    }
	}

	
//////////////
	@Override
	public boolean deleteCustomers(CustomersDTO customersDTO) {
		
		Customers customers = new Customers();
		customers.setCustomerId(customersDTO.getCustomerId());
		customerRepository.delete(customers);
		return true;
	}

	@Override
	public List<CustomersDTO> findAll() {
		
		List<Customers> customers = customerRepository.findAll();
		List<CustomersDTO> dtos = new ArrayList<>();
		for (Customers customer : customers) {
			CustomersDTO dto = new CustomersDTO();
			BeanUtils.copyProperties(customer, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public CustomersDTO getById(int id) {
		
		Optional<Customers> customers = customerRepository.findById(id);
		if (customers.isPresent()) {
			CustomersDTO dto = new CustomersDTO();
			BeanUtils.copyProperties(customers.get(), dto);
			return dto;
		}
		return null;

	}

}

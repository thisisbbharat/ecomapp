package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.AddPaymentDTO;
import com.cg.ecom.dto.PaymentDTO;

public interface PaymentService {

	public PaymentDTO addPayment(AddPaymentDTO addPaymentDTO);
	
	public boolean deletePayment(PaymentDTO paymentDTO);

	public PaymentDTO getById(int id);

	public List<PaymentDTO> findAll();

}

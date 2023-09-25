package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.AddOrdersDTO;
import com.cg.ecom.dto.OrdersDTO;

public interface OrdersService {

	public OrdersDTO addOrders(AddOrdersDTO addOrdersDTO);

	public OrdersDTO updateOrders(OrdersDTO ordersDTO);

	public boolean deleteOrders(OrdersDTO ordersDTO);

	public OrdersDTO getById(int id);

	public List<OrdersDTO> findAll();

}

package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.AddCartDTO;
import com.cg.ecom.dto.CartDTO;

public interface CartService {

	public CartDTO addToCart(AddCartDTO addCartDTO);

	public CartDTO updateCart(CartDTO cartDTO);

	public boolean deleteCart(CartDTO cartDTO);

	public CartDTO getById(int id);

	public List<CartDTO> findAll();

}

package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.AddCartDTO;
import com.cg.ecom.dto.CartDTO;
import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.entity.ProductItems;
import com.cg.ecom.exceptions.CartIdAlreadyExistsException;
import com.cg.ecom.repository.CartRepository;
import com.cg.ecom.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDTO addToCart(AddCartDTO addCartDTO) {

		Cart cart = new Cart();
		Customers cust = new Customers();
		ProductItems product = new ProductItems();
		
		product.setProductId(addCartDTO.getProductId());
		cust.setCustomerId(addCartDTO.getCustomerId());
		cart.setCustomers(cust);
		cart.setProductItems(product);
		cart.setQuantity(addCartDTO.getQuantity());

		Cart cartsave = cartRepository.save(cart);
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCartId(cartsave.getCartId());
		cartDTO.setCustomerId(cartsave.getCustomers().getCustomerId());
		cartDTO.setProductId(cartsave.getProductItems().getProductId());
		cartDTO.setQuantity(cartsave.getQuantity());
		

		return cartDTO;


	}

	@Override
	public CartDTO updateCart(CartDTO cartDTO) 
	{
		Optional<Cart> optionalCart = cartRepository.findById(cartDTO.getCustomerId());
	    if (optionalCart.isPresent()) {
		
		Cart cart = new Cart();
		cart.setQuantity(cartDTO.getQuantity());
		cart.setCartId(cartDTO.getCartId());


		cartRepository.save(cart);
		return cartDTO;
	}
	else {
        throw new CartIdAlreadyExistsException();
    }
}
	    

	@Override
	public boolean deleteCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cartRepository.delete(cart);
		return true;
	}

	@Override
	public CartDTO getById(int id) {

		Optional<Cart> cart = cartRepository.findById(id);
		if (cart.isPresent()) {
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(cart.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CartDTO> findAll() {

		List<Cart> cart = cartRepository.findAll();
		List<CartDTO> dtos = new ArrayList<>();
		for (Cart carts : cart) {
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(carts, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}

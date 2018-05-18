package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;

public interface AddCartService {

	public String addToCart(OrderDTO orderDTO);
}

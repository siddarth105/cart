package com.ecomm.chkt.cart.service;

import org.springframework.stereotype.Service;

import com.ecomm.chkt.cart.model.Order;

@Service
public class AddCartServiceImpl implements AddCartService {
	
	@Override
	public String addToCart(Order order) {
		return "success";
	}

}

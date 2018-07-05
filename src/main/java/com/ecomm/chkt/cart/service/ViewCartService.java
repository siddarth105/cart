package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;

public interface ViewCartService {
	
	public OrderDTO getOrder(Integer orderId);

}

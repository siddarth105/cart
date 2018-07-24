package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;

public interface ViewCartService {
	
	OrderDTO getOrder(Integer orderId);

}

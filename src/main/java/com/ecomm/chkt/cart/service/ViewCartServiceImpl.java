package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.AddCartRepository;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.mapper.OrderToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewCartServiceImpl implements ViewCartService {

	@Autowired
	private AddCartRepository addCartRepository;

	@Autowired
	private OrderToDtoMapper orderToDtoMapper;
	
	@Override
	public OrderDTO getOrder(Integer orderId) {

		List<Order> ordrLst = addCartRepository.viewAllCart(orderId);
		return orderToDtoMapper.map(ordrLst);
	}
	
}

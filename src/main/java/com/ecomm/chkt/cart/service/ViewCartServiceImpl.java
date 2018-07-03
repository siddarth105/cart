package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.AddCartRepository;
import com.ecomm.chkt.cart.repository.domain.Order;
import com.ecomm.chkt.cart.repository.mapper.OrderToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ViewCartServiceImpl implements ViewCartService {

	@Autowired
	private AddCartRepository addCartRepository;

	@Autowired
	private OrderToDtoMapper orderToDtoMapper;
	
	@Override
	public OrderDTO getOrder() {

		List<Order> ordrLst = addCartRepository.viewAllCart();
		Collections.sort(ordrLst, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				return o1.getOrderId() > o2.getOrderId() ? 1 : -1;
			}
		});
		return orderToDtoMapper.map(ordrLst);
	}
	
}

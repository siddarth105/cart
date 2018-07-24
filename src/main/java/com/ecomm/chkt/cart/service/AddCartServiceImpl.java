package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.repository.AddCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCartServiceImpl implements AddCartService {

	@Autowired
	private AddCartRepository addCartRepository;

	@Autowired
	private InventoryService inventoryService;

	@Override
	public String addToCart(OrderDTO orderDTO) {
		inventoryService.checkInventory(orderDTO.getItemList());
		addCartRepository.insert(orderDTO, true);
		return "success";
	}

}

package com.ecomm.chkt.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.chkt.cart.model.Item;
import com.ecomm.chkt.cart.model.Order;

@Service
public class ViewCartServiceImpl implements ViewCartService {
	
	@Override
	public Order getOrder() {
		List<Item> itemsLst = new ArrayList<Item>();
		itemsLst.add(new Item(30, "Brush"));
		itemsLst.add(new Item(43, "Paste"));
		Order ordr = new Order(1234, itemsLst, "N");
		return ordr;
	}
	
}

package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.model.ItemDTO;
import com.ecomm.chkt.cart.model.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewCartServiceImpl implements ViewCartService {
	
	@Override
	public OrderDTO getOrder() {
		List<ItemDTO> itemsLst = new ArrayList<ItemDTO>();
		itemsLst.add(new ItemDTO(30, "Brush"));
		itemsLst.add(new ItemDTO(43, "Paste"));
		OrderDTO ordr = new OrderDTO(1234, itemsLst, "N");
		return ordr;
	}
	
}

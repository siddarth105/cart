package com.ecomm.chkt.cart.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.chkt.cart.model.Order;
import com.ecomm.chkt.cart.service.AddCartService;

@RestController
@RequestMapping(value = "/rest")
public class AddToCartController {
	
	@Autowired
	private AddCartService addCartService;
	
	private final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(method=RequestMethod.POST, value = "/addToCart")
	public String addToCart(@RequestBody Order order) {
		this.log.info("AddToCartController :: addToCart");
		String result = addCartService.addToCart(order);
		return result;
	}

}

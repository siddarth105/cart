package com.ecomm.chkt.cart.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.chkt.cart.model.Order;
import com.ecomm.chkt.cart.service.ViewCartService;

@RestController
@RequestMapping(value = "/rest")
public class ViewCartController {
	
	@Autowired
	private ViewCartService viewCartService;
	
	private final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(method=RequestMethod.GET, value = "/viewCart")
	public Order viewCart() {
		this.log.info("ViewCartController :: viewCart");
		return viewCartService.getOrder();
	}

}

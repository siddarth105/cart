package com.ecomm.chkt.cart.controller;

import com.ecomm.chkt.cart.model.OrderDTO;
import com.ecomm.chkt.cart.service.ViewCartService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class ViewCartController {
	
	@Autowired
	private ViewCartService viewCartService;
	
	private final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(method=RequestMethod.GET, value = "/viewCart")
	public OrderDTO viewCart(@RequestParam(value = "orderId", required = false) Integer orderId) {
		this.log.info("ViewCartController :: viewCart");
		return viewCartService.getOrder(orderId);
	}

}

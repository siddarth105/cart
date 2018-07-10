package com.ecomm.chkt.cart.controller;

import com.ecomm.chkt.cart.service.PaymentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class OrderSubmitController {

    @Autowired
    private PaymentService paymentService;

    private final Log log = LogFactory.getLog(getClass());

    @RequestMapping(method=RequestMethod.GET, value = "/makePayment")
    public String makePayment(@RequestParam(value = "orderId", required = true) Integer orderId) {
        this.log.info("OrderSubmitController :: makePayment");
        Integer amt = 105;
        return paymentService.makePayment(orderId, amt);
    }
}

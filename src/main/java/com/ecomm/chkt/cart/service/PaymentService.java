package com.ecomm.chkt.cart.service;

public interface PaymentService {

    String makePayment(Integer orderId, Integer amt);
}

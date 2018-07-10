package com.ecomm.chkt.cart.service;

import com.ecomm.chkt.cart.callback.PaymentCallback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

@Service
public class PaymentServImpl implements PaymentService {

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    private final Log log = LogFactory.getLog(getClass());

    String paymentUrl = "http://localhost:8091/rest/makePayment?amount=";

    public String makePayment(Integer orderId, Integer amt) {

        HttpEntity<?> requestHttpEntity = HttpEntity.EMPTY;
        this.log.info("PaymentServImpl :: Calling Payment service...");
        final ListenableFuture<ResponseEntity<String>> response = asyncRestTemplate.exchange(paymentUrl + amt, HttpMethod.GET, requestHttpEntity, String.class);
        this.log.info("PaymentServImpl :: After Payment service call");
        response.addCallback(new PaymentCallback());
        return "SUCCESS";
    }

}

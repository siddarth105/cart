package com.ecomm.chkt.cart.callback;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class PaymentCallback implements ListenableFutureCallback<ResponseEntity<String>> {

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void onFailure(Throwable throwable) {
        this.log.info("PaymentCallback :: onFailure");
    }

    @Override
    public void onSuccess(ResponseEntity<String> stringResponseEntity) {
        this.log.info("PaymentCallback :: onSuccess");
        this.log.info("Response from payment service -> " + stringResponseEntity.getBody());
    }
}

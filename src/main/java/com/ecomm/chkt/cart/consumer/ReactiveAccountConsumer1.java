package com.ecomm.chkt.cart.consumer;

import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

import reactor.core.publisher.BaseSubscriber;

@Component
public class ReactiveAccountConsumer1<String> extends BaseSubscriber<String>{
	
	public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(1);
	}

	public void hookOnNext(String value) {
        System.out.println("Subscriber_1 :: " + value);
        request(1);
	}
}

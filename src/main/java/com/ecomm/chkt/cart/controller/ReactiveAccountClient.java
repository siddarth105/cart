package com.ecomm.chkt.cart.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/rest")
public class ReactiveAccountClient {
	
	// TODO :: Handling back-pressure, adding more consumers, adding callbacks for handling errors
	
	@Autowired
	private WebClient webClient;
	
	private final Log log = LogFactory.getLog(getClass());
	
	private static final String paymentAccountUrl = "http://localhost:8091/rest/getAccount";
	
	@GetMapping(value = "/getReactivePaymentAccount")
	public void getReactivePaymentAccount() {
		this.log.info("ReactiveCartAccountController :: getReactivePaymentAccount");
		getPaymentAccountMono()
		.subscribe(cr -> cr.bodyToFlux(String.class)			// Cast it to the actual Type emitted by the Flux. Can be custom class also (Eg:Item.class)
				.map(userName -> "Cart :: " + userName)		// Perform necessary operation on each element
				.subscribe(System.out::println));			// Start listening to the FLUX, can add more consumers inside subscribe
	}
	
	Mono<ClientResponse> getPaymentAccountMono() {
		 return webClient.get().uri(paymentAccountUrl)
		.exchange();
	}
}

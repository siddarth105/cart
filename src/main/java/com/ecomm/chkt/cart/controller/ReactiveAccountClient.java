package com.ecomm.chkt.cart.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.ecomm.chkt.cart.consumer.ReactiveAccountConsumer1;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/rest")
public class ReactiveAccountClient {

	// TODO :: Handling back-pressure, adding more consumers, adding callbacks for handling errors

	@Autowired
	private WebClient webClient;
	
	@Autowired
	private ReactiveAccountConsumer1<String> reactiveAccountConsumer1;

	private final Log log = LogFactory.getLog(getClass());

	private static final String PAYMENT_ACCOUNT_URL = "http://localhost:8091/rest/getAccount";
	private static final String PAYMENT_CONNECTABLE_ACCOUNT_URL = "http://localhost:8091/rest/getConnectableAccountFlux";

	@GetMapping(value = "/getReactivePaymentAccount")
	public void getReactivePaymentAccount() {
		this.log.info("ReactiveAccountClient :: getReactivePaymentAccount");
		getFluxFromRetrieve(PAYMENT_ACCOUNT_URL)
				.map(userName -> "Cart :: " + userName)																			// Perform necessary operation on each element
				.subscribe(System.out::println);																					// Start listening to the FLUX, can add more consumers inside subscribe

	}

	@GetMapping(value = "/getConnectableAccountFlux")
	public void getConnectableAccountFlux() {
		this.log.info("ReactiveAccountClient :: getConnectableAccountFlux");
		ConnectableFlux<String> connectableFlux = getFluxFromExchange(PAYMENT_ACCOUNT_URL).publish();								// publish() -> converts FLUX to CONNECTABLE_FLUX where multiple consumers can subscribe. Flux will be consumed only on connect and not on subscribe
		connectableFlux.connect();
		connectableFlux.subscribe(reactiveAccountConsumer1);
		connectableFlux.subscribe(d -> System.out.println("Subscriber_2 :: " + d));
	}

	Flux<String> getFluxFromExchange(String url) {
		return webClient.get().uri(url)																							// Use get() or post() depending on the type of HTTP menthod you are calling
				.exchange()																										// Exchange always returns Mono
				.flatMapMany(d -> d.bodyToFlux(String.class));																	// Cast Mono to Flux<Type> that is emitted. Can be custom class also (Eg:Item.class)
	}

	Flux<String> getFluxFromRetrieve(String url) {
		return webClient.get().uri(url)
				.retrieve()																										// Retrieve directly returns the element
				.bodyToFlux(String.class);
	}

	/* webClient.get().uri(PAYMENT_ACCOUNT_URL)
		.exchange()
		.subscribe(cr -> cr.bodyToFlux(String.class)
				.map(userName -> "Cart :: " + userName)
				.subscribe(System.out::println)); */
}

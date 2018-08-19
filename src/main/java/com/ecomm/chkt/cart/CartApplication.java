package com.ecomm.chkt.cart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ecomm.chkt.cart.repository.CassandraConnector;

@SpringBootApplication
public class CartApplication {

	private final Log log = LogFactory.getLog(getClass());
	
	@Bean
	WebClient webClient() {
		return WebClient.create();
	};
	
	@Bean
	public AsyncRestTemplate asyncRestTemplate(){
		return new AsyncRestTemplate();
	}
	
	public static void main(String[] args) {
		CassandraConnector.getInstance().connect("localhost", 9042);
		SpringApplication.run(CartApplication.class, args);
	}
}

package com.ecomm.chkt.cart;

import com.ecomm.chkt.cart.repository.CassandraConnector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication
public class CartApplication {

	private final Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {

		CassandraConnector.getInstance().connect("localhost", 32769);
		SpringApplication.run(CartApplication.class, args);
	}

	@Bean
	public AsyncRestTemplate asyncRestTemplate(){
		return new AsyncRestTemplate();
	}
}

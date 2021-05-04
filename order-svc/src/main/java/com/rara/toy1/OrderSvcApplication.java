package com.rara.toy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OrderSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSvcApplication.class, args);
	}

}

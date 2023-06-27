package com.springboot.demo.database;

import com.springboot.demo.model.Product;
import com.springboot.demo.repository.ProductRepository;
import com.springboot.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Database {
	 private static final Logger logger = LoggerFactory.getLogger(Database.class);

	@Bean
	CommandLineRunner initProduct(ProductService productService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				final var product1 = new Product(1L, "pen", 2023, 5000d, "aa");
				final var product2 = new Product(2L, "book", 2023, 10000d, "aa");
				productService.save(Arrays.asList(product1, product2));
			}
		};
	}
}

package com.springboot.demo.controller;

import com.springboot.demo.data.ResponseData;
import com.springboot.demo.model.Product;
import com.springboot.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping("/get-{id}")
	ResponseEntity<ResponseData> getById(@PathVariable Long id) {
		final var found = productService.find(id);
		if (found.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseData("ok", "Find product successfully", found)
			);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseData("failed", "Cannot find product with id: " + id, null)
			);
		}
	}

	@PostMapping("/insert")
	ResponseEntity<ResponseData> insert(@RequestBody Product product) {
		try {
			final var saved = productService.save(product);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseData("ok", "Save new product successfully", saved)
			);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseData("failed", "Failed to save product", product)
			);
		}
	}
}

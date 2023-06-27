package com.springboot.demo.service;

import com.springboot.demo.model.Product;
import com.springboot.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public Optional<Product> find(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	public void save(List<Product> saveds) {
		productRepository.saveAll(saveds);
	}

	@Transactional
	public Product save(Product saved) {
		return productRepository.save(saved);
	}
}

package com.pma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pma.business.Product;
import com.pma.business.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping(path="/")
	public Iterable<Product> getAll() {
		return productRepo.findAll();
		
	}

	@GetMapping("/{id}")
	public Optional<Product> get(@PathVariable int id) {
		return productRepo.findById(id);
		
	}
	
	@PostMapping("/")
	public Product add(@RequestBody Product p) {
		return productRepo.save(p);
		
	}
}

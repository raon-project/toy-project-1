package com.rara.toy1.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rara.toy1.product.domain.Product;
import com.rara.toy1.product.dto.ProductSaveRequestDto;
import com.rara.toy1.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/toy1")
@RestController
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/products/v1/{id}")
	public Product createProduct(@PathVariable Long id) {
		return productService.retrieveProduct(id);
	}
	
	@PostMapping("/products/v1")
	public Long createProduct(@RequestBody ProductSaveRequestDto productSaveRequestDto) {
		return productService.createProduct(productSaveRequestDto);
	}

}

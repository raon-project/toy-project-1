package com.rara.toy1.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rara.toy1.common.dto.product.ProductResponseDto;
import com.rara.toy1.product.dto.ProductSaveRequestDto;
import com.rara.toy1.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/toy1")
@RestController
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/products/v1/{id}")
	public ProductResponseDto retrieveProduct(@PathVariable Long id) {
		
		try {
			new Thread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productService.retrieveProduct(id);
	}
	
	@PostMapping("/products/v1")
	public Long createProduct(@RequestBody ProductSaveRequestDto productSaveRequestDto) {
		return productService.createProduct(productSaveRequestDto);
	}

}

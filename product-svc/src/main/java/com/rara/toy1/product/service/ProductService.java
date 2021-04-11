package com.rara.toy1.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rara.toy1.product.domain.Product;
import com.rara.toy1.product.domain.ProductRepository;
import com.rara.toy1.product.dto.ProductSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public Product retrieveProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Long createProduct(ProductSaveRequestDto productSaveRequestDto) {
		
		Product product =productSaveRequestDto.toEntity();
		
		productRepository.save(product);
		
		return product.getId();
	}

}

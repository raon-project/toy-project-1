package com.rara.toy1.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rara.toy1.common.dto.product.ProductResponseDto;
import com.rara.toy1.product.domain.Product;
import com.rara.toy1.product.domain.ProductRepository;
import com.rara.toy1.product.dto.ProductSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductResponseDto retrieveProduct(Long id) {
		
		Product product = productRepository.findById(id).orElse(null);
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setId(product.getId());
		productResponseDto.setProdName(product.getProdName());
		productResponseDto.setProdTypeCode(product.getProdTypeCode());
		productResponseDto.setProdPrice(product.getProdPrice());
		productResponseDto.setProdStock(product.getProdStock());
		
		return productResponseDto;
	}
	
	public Long createProduct(ProductSaveRequestDto productSaveRequestDto) {
		
		Product product =productSaveRequestDto.toEntity();
		
		productRepository.save(product);
		
		return product.getId();
	}

}

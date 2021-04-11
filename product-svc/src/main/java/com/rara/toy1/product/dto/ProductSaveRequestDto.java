package com.rara.toy1.product.dto;

import java.math.BigDecimal;

import com.rara.toy1.product.domain.Product;

import lombok.Data;

@Data
public class ProductSaveRequestDto {
	
	private String prodTypeCode;
	private String productName;
	private int productPrice;
	private int productStock;
	
	public Product toEntity() {
		Product product = Product.builder()
								 .prodTypeCode(prodTypeCode)
								 .prodName(productName)
								 .prodPrice(new BigDecimal(productPrice))
								 .prodStock(productStock)
								 .build();
		
		return product;
	}

}

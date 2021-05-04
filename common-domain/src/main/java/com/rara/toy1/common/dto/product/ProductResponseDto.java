package com.rara.toy1.common.dto.product;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductResponseDto {
	
	private Long id;
	
	private String prodTypeCode;
	
	private String prodName;
	
	private BigDecimal prodPrice;
	
	private int prodStock;
	
}

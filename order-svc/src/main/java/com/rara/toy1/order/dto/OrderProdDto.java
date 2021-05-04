package com.rara.toy1.order.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProdDto {
	
	private Long prodId;
	
	private int orderProdQuantity;
	
	private BigDecimal orderProdPrice;

}

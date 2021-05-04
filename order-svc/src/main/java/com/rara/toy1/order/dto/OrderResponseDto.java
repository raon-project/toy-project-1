package com.rara.toy1.order.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponseDto {
	
	private Long orderId;
	
	private Long customerId;
	
	private String customerName;
	
	private List<OrderProdResponseDto> orderProdDtoList;
	
}

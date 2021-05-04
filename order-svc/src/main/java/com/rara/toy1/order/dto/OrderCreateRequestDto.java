package com.rara.toy1.order.dto;

import java.util.List;

import com.rara.toy1.order.domain.Order;

import lombok.Data;

@Data
public class OrderCreateRequestDto {
	
	private Long customerId;
	
	private List<OrderProdDto> orderProdDtoList;
	
	public Order toEntity() {
		Order order = Order.builder()
						   .customerId(customerId)
						   .build();
		
		// ��ǰ �� ���� List�� Entity�� add ����� ���� �����Ѵ�.
		orderProdDtoList.stream().forEach(dto -> order.addOrderDetail(dto));
		
		return order;
	}

}

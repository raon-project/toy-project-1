package com.rara.toy1.order.domain;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.rara.toy1.order.dto.OrderProdResponseDto;
import com.rara.toy1.order.dto.OrderResponseDto;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderMapper {
	
	@Mapping(source = "orderDetailList", target = "orderProdDtoList")
	public OrderResponseDto toOrderResponseDto(Order order);
	
	public List<OrderProdResponseDto> toOrderResponseDto(List<OrderDetail> orderDetailList);

}

package com.rara.toy1.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.rara.toy1.common.dto.product.ProductResponseDto;
import com.rara.toy1.common.dto.user.UserResponseDto;
import com.rara.toy1.order.domain.Order;
import com.rara.toy1.order.dto.OrderCreateRequestDto;
import com.rara.toy1.order.dto.OrderProdResponseDto;
import com.rara.toy1.order.dto.OrderResponseDto;
import com.rara.toy1.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final WebClient.Builder builder;
	
	//private final DomainEventPublisher domainEventPublisher;
	
	public Mono<OrderResponseDto> retrieveOrder(Long id) {
		
		Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
		
		WebClient webClient = builder.build();
		
		Mono<UserResponseDto> user = webClient.get().uri("http://localhost:8030/toy1/users/v1/"+order.getCustomerId())
												    .retrieve()
												    .bodyToMono(UserResponseDto.class);
		
		List<Long> prodIds = order.getOrderDetailList().stream().map(p -> p.getProdId()).collect(Collectors.toList());
	
		Mono<Map<Long, ProductResponseDto>> prodMap = Flux.fromIterable(prodIds)
							.flatMap(this::getProduct).collectMap(p -> p.getId(), p -> p);
	
		return Mono.zip(user, prodMap).map(tuple -> {
			
			OrderResponseDto orderResponseDto = new OrderResponseDto();
			orderResponseDto.setOrderId(order.getId());
			orderResponseDto.setCustomerId(tuple.getT1().getId());
			orderResponseDto.setCustomerName(tuple.getT1().getUserNm());
			
			List<OrderProdResponseDto> orderProdDtoList = new ArrayList<>();
			order.getOrderDetailList().forEach(entity -> {
				OrderProdResponseDto orderProdResponseDto = new OrderProdResponseDto();
				orderProdResponseDto.setProdId(entity.getProdId());
				orderProdResponseDto.setProdName(tuple.getT2().get(entity.getProdId()).getProdName());
				orderProdResponseDto.setOrderProdPrice(entity.getOrderProdPrice());
				orderProdResponseDto.setOrderProdQuantity(entity.getOrderProdQuantity());
				orderProdDtoList.add(orderProdResponseDto);
			});
			
			orderResponseDto.setOrderProdDtoList(orderProdDtoList);
			
			return orderResponseDto;
		});
		
	}
	
	public Mono<ProductResponseDto> getProduct(Long id){
		WebClient webClient = builder.build();
		
		return webClient.get().uri("http://localhost:8010/toy1/products/v1/"+id)
				   .retrieve()
				   .bodyToMono(ProductResponseDto.class);
	}
	
	public Long createOrder(OrderCreateRequestDto orderCreateRequestDto) {
		
		Order order = orderCreateRequestDto.toEntity();
		
		// 생성 초기값 셋팅
		order.createOrder();
		
		orderRepository.save(order);
		
		return order.getId();
	}

}

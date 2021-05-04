package com.rara.toy1.order.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rara.toy1.order.dto.OrderCreateRequestDto;
import com.rara.toy1.order.dto.OrderResponseDto;
import com.rara.toy1.order.service.OrderService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/toy1")
public class OrderController {
	
	private final OrderService orderService;
	
	@GetMapping("/orders/v1/{id}")
	public Mono<OrderResponseDto> retrieveOrder2(@PathVariable Long id) {
		return orderService.retrieveOrder(id);
	}
	
	@PostMapping("/orders/v1")
	public Long createOrder(@RequestBody OrderCreateRequestDto orderCreateRequestDto) {
		return orderService.createOrder(orderCreateRequestDto);
	}

}

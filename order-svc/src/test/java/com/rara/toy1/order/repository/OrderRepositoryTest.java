package com.rara.toy1.order.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.rara.toy1.order.domain.Order;
import com.rara.toy1.order.dto.OrderProdDto;

@SpringBootTest
@Transactional
@Rollback(true)
public class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void testOrder01() {
		
		// Given
		Order order = Order.builder()
							.customerId(1L)
							.build();
		
		order.addOrderDetail(new OrderProdDto(10L, 1, new BigDecimal(3000)));
		order.addOrderDetail(new OrderProdDto(11L, 2, new BigDecimal(7000)));
		
		order.createOrder();
		
		// When
		orderRepository.save(order);
		
		em.flush();
		em.clear();
		
		Order selectOrder = orderRepository.findById(order.getId()).get();
		
		// Then
		assertThat(order.getId()).isEqualTo(selectOrder.getId());
		assertThat(order.getCustomerId()).isEqualTo(selectOrder.getCustomerId());
		assertThat(order.getOrderDetailList().size()).isEqualTo(selectOrder.getOrderDetailList().size());
	}

}

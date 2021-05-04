package com.rara.toy1.order.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rara.toy1.common.constant.OrderStatus;
import com.rara.toy1.common.domain.base.BaseEntity;
import com.rara.toy1.order.dto.OrderProdDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ORDER")
@Getter
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 데이터 베이스에 위임
	private Long id;
	
	private LocalDateTime orderDate;
	
	private Long customerId;
	
	private BigDecimal totalPrice;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatusCode;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderDetail> orderDetailList = new ArrayList<>();

	@Builder
	private Order(Long id, LocalDateTime orderDate, Long customerId, BigDecimal totalPrice, OrderStatus orderStatusCode) {
		this.id = id;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.orderStatusCode = orderStatusCode;
	}
	
	public void addOrderDetail(OrderProdDto orderProdDto) {
		
		OrderDetail orderDetail  = OrderDetail.builder()
								              .order(this)	// 양방향 객체 매핑
								              .prodId(orderProdDto.getProdId())
								              .orderProdPrice(orderProdDto.getOrderProdPrice())
								              .orderProdQuantity(orderProdDto.getOrderProdQuantity())
								              .build();
		orderDetailList.add(orderDetail);
	}
	
	public void createOrder() {
		this.orderDate = LocalDateTime.now();
		this.orderStatusCode = OrderStatus.ORDER_RECEIPT;
		
		// orderDetailList에 포함된 금액의 총합을 계산한다.
		this.totalPrice = orderDetailList.stream().map(dto -> dto.getOrderProdPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
}

package com.rara.toy1.order.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rara.toy1.common.domain.base.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ORDER_DETAIL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 데이터 베이스에 위임
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	private Long productId;
	
	private int orderProductQuantity;
	
	private BigDecimal orderProductPrice;

	@Builder
	public OrderDetail(Long id, Order order, Long productId, int orderProductQuantity,
			BigDecimal orderProductPrice) {
		this.id = id;
		this.order = order;
		this.productId = productId;
		this.orderProductQuantity = orderProductQuantity;
		this.orderProductPrice = orderProductPrice;
	}
	
}

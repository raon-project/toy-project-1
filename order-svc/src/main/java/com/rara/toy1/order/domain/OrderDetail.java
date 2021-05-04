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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ORDER_DETAIL")
@Getter
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 데이터 베이스에 위임
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	private Long prodId;
	
	private int orderProdQuantity;
	
	private BigDecimal orderProdPrice;

	@Builder
	public OrderDetail(Long id, Order order, Long prodId, int orderProdQuantity,
			BigDecimal orderProdPrice) {
		this.id = id;
		this.order = order;
		this.prodId = prodId;
		this.orderProdQuantity = orderProdQuantity;
		this.orderProdPrice = orderProdPrice;
	}
	
}

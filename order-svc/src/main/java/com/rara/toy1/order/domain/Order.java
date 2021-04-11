package com.rara.toy1.order.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rara.toy1.common.domain.base.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ORDER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 데이터 베이스에 위임
	private Long id;
	
	private LocalDateTime orderDate;
	
	private Long customerId;
	
	private BigDecimal totalPrice;
	
	private String orderStatusCode;

	@Builder
	private Order(Long id, LocalDateTime orderDate, Long customerId, BigDecimal totalPrice,
			String orderStatusCode) {
		this.id = id;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.orderStatusCode = orderStatusCode;
	}
	
}

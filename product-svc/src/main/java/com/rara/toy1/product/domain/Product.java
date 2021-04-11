package com.rara.toy1.product.domain;

import java.math.BigDecimal;

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
@Table(name = "TB_PRODUCT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 데이터 베이스에 위임
	private Long id;
	
	private String prodTypeCode;
	
	private String prodName;
	
	private BigDecimal prodPrice;
	
	private int prodStock;
	
	@Builder
	private Product(Long id, String prodTypeCode, String prodName, BigDecimal prodPrice, int prodStock) {
		this.id = id;
		this.prodTypeCode = prodTypeCode;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
	}
	
}

package com.rara.toy1.common.domain.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@CreatedDate
	@Column(updatable=false, name = "created_date")
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	public String getCreatedDate() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		return createdDate.format(dateTimeFormatter);
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

}

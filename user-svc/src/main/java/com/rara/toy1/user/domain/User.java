package com.rara.toy1.user.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.rara.toy1.common.domain.base.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String emailId;

    private String userNm;

    private String password;
    
    private BigDecimal credit;
    
    @ElementCollection
    @CollectionTable(name = "TB_USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    private List<String> roles = new ArrayList<>();

    @Builder
    private User(Long id, String emailId, String userNm, String password, BigDecimal credit, List<String> roles) {
		this.id = id;
		this.emailId = emailId;
		this.userNm = userNm;
		this.password = password;
		this.credit = credit;
		this.roles = roles;
	}
    
}

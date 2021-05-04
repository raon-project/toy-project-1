package com.rara.toy1.common.dto.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserResponseDto {
	
	private Long id;
	
	private String emailId;
	
	private String userNm;
	
}

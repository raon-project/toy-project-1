package com.rara.toy1.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rara.toy1.common.dto.user.UserResponseDto;
import com.rara.toy1.user.domain.User;
import com.rara.toy1.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserResponseDto retrieveUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
		
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setEmailId(user.getEmailId());
		userResponseDto.setUserNm(user.getUserNm());
		
		return userResponseDto;
	}

}

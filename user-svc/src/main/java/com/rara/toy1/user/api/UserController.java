package com.rara.toy1.user.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rara.toy1.common.dto.user.UserResponseDto;
import com.rara.toy1.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/toy1")
public class UserController {
	
	private final UserService orderService;
	
	@GetMapping("/users/v1/{id}")
	public UserResponseDto retrieveUser(@PathVariable Long id) {
		
		try {
			new Thread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderService.retrieveUser(id);
	}

}

package com.phatbt027.XPhone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phatbt027.XPhone.dto.UserDto;
import com.phatbt027.XPhone.entity.User;
import com.phatbt027.XPhone.service.UserService;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping
	private List<UserDto> getAllUser() {
		
		return userService.getAllUser();
	}
	
	@GetMapping("/{username}")
	private UserDto getUserByUsername(@PathVariable("username") String username) {
		
		return userService.getUserByUsername(username);
	}
	
	@PostMapping("/save")
	private User register(@RequestBody UserDto userDto) {

		return userService.saveUser(userDto);
	}

	@DeleteMapping("/delete/{userId}")
	private void deleteUser(@PathVariable("userId") int userId) {

		userService.deleteUser(userId);
	}

	@PutMapping("/update")
	private User updateUser(UserDto userDto) {

		return userService.updateUser(userDto);
	}
}

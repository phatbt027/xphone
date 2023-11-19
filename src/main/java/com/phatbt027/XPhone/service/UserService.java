package com.phatbt027.XPhone.service;

import java.util.List;

import com.phatbt027.XPhone.dto.UserDto;
import com.phatbt027.XPhone.entity.User;

public interface UserService {
	
	List<UserDto> getAllUser();
	
	UserDto getUserById(int id);
	
	UserDto getUserByUsername(String password);
	
	User saveUser(UserDto userDto);

	void deleteUser(int userId);

	User updateUser(UserDto userDto);
}

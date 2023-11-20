package com.phatbt027.XPhone.service;

import java.util.List;

import com.phatbt027.XPhone.dto.UserDto;
import com.phatbt027.XPhone.entity.User;

public interface UserService {
	
	List<UserDto> getAllUser();
	
	UserDto getUserById(int id);
	
	UserDto getUserByUsername(String password);
	
	User saveUser(final UserDto userDto);

	void deleteUser(int userId);

	User updateUser(final UserDto userDto);
}

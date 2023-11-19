package com.phatbt027.XPhone.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phatbt027.XPhone.dto.UserDto;
import com.phatbt027.XPhone.entity.Role;
import com.phatbt027.XPhone.entity.User;
import com.phatbt027.XPhone.exception.ResourceNotFoundException;
import com.phatbt027.XPhone.repository.UserRepository;
import com.phatbt027.XPhone.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// Get user by user id
	@Override
	public UserDto getUserById(int id) {

        return mapUserDto(userRepository.findUserById(id)
				.orElseThrow(() -> new ResourceNotFoundException("USER ID NOT FOUND")));
	}

	// Get user by username
	@Override
	public UserDto getUserByUsername(String username) {

        return mapUserDto(userRepository.findUserByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("USERNAME NOT FOUND!!!")));
	}

	// Get all user by list
	@Override
	public List<UserDto> getAllUser() {

		List<UserDto> userDtoList = new ArrayList<UserDto>();
		
		for(User user : userRepository.findAll()) {
			UserDto dto = mapUserDto(user);
			userDtoList.add(dto);
		}
		
		return userDtoList;
	}

	// Save user by user dto
	@Override
	public User saveUser(UserDto dto) {

		User user = mapUser(dto);

		return userRepository.save(user);
	}

	// Delete user by user id
	@Override
	public void deleteUser(int userId) {

		userRepository.delete(userRepository.findUserById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found")));
	}

	// Update user by user dto
	@Override
	public User updateUser(UserDto dto) {

		User user = mapUser(dto);

		return userRepository.save(user);
	}

	// Mapping user dto to user
	private UserDto mapUserDto(User user) {
		
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole().name());

		return dto;
	}

	// Mapping user to user dto
	private User mapUser(UserDto dto) {
		
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(Role.valueOf(dto.getRole()));
		
		return user;
	}
}

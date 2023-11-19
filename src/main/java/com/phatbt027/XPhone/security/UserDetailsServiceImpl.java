package com.phatbt027.XPhone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phatbt027.XPhone.entity.User;
import com.phatbt027.XPhone.exception.ResourceNotFoundException;
import com.phatbt027.XPhone.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findUserByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("USER NOT FOUND !!!"));
		
		return new MyUserDetails(user);
	}
}

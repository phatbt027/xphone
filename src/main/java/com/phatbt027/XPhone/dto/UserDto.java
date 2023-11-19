package com.phatbt027.XPhone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
	private int id;
	private String username;
	private String password;
	private String role;
}

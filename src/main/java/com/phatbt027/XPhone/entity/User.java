package com.phatbt027.XPhone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User{

	@Id
	private int id;
	
	private String username;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}

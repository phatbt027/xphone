package com.phatbt027.XPhone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phatbt027.XPhone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findUserById(int id);
	
	Optional<User> findUserByUsername(String username);
}

package com.hari.serverproductmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.serverproductmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//findBy +username
	
	Optional<User> findByUsername(String username);
	

}

package com.hari.serverproductmanagement.service;

import java.util.List;

import com.hari.serverproductmanagement.model.User;

public interface UserService {

	User saveUser(User user);
	
	User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUsers();

}

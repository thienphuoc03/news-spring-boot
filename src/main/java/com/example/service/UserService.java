package com.example.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.dto.UserDTO;
import com.example.model.User;

@Component
public interface UserService {
	List<UserDTO> getAllUsers();

	UserDTO getUserById(long id);

	ResponseEntity<User> addUser(UserDTO userDTO);

	ResponseEntity<User> updateUser(UserDTO userDTO);

	ResponseEntity<HttpStatus> deleteUser(Long id);

	String passwordEncoding(String password);
}

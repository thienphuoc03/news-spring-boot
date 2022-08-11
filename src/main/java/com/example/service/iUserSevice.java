package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.UserDTO;

@Component
public interface iUserSevice {
	List<UserDTO> getAllUsers();

	UserDTO getUserById(long id);
}

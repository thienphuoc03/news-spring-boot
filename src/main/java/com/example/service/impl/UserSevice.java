package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import com.example.service.iUserSevice;

@Service
public class UserSevice implements iUserSevice {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity user : entities) {
			UserDTO userDTO = userMapper.toDto(user);
			results.add(userDTO);
		}

		return results;
	}

	@Override
	public UserDTO getUserById(long id) {
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity user : entities) {
			if (user.getId() == id) {
				UserDTO userDTO = userMapper.toDto(user);
				return userDTO;
			}
		}

		throw new com.example.exception.NotFoundException("NOT_FOUND_USER_IN_SYSTEM");
	}

}

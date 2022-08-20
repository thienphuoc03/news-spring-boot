package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.exception.NotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserSevice;

@Service
public class UserSeviceImpl implements UserSevice {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> results = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			results.add(userDTO);
		}

		return results;
	}

	@Override
	public UserDTO getUserById(long id) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getId() == id) {
				UserDTO userDTO = modelMapper.map(user, UserDTO.class);
				return userDTO;
			}
		}

		throw new NotFoundException("NOT_FOUND_USER_IN_SYSTEM");
	}

}

package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.exception.NotFoundException;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String passwordEncoding(String password) {
		return passwordEncoder.encode(password);
	}

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

	@Override
	public ResponseEntity<User> addUser(UserDTO userDTO) {
		User user = new User();

		List<User> users = userRepository.findAll();
		for (User item : users) {
			if (userDTO.getUsername() != item.getUsername()) {
				modelMapper.map(userDTO, user);
				user.setPassword(passwordEncoding(userDTO.getPassword()));
				User newUser = userRepository.save(user);

				return new ResponseEntity<>(newUser, HttpStatus.CREATED);
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<User> updateUser(UserDTO userDTO) {
		User oldUser = userRepository.findOne(userDTO.getId());
		if (oldUser != null) {
			oldUser = modelMapper.map(userDTO, oldUser.getClass());
			User updateUser = userRepository.save(oldUser);

			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		}

		throw new NotFoundException("User_DOES_NOT_EXIST");
	}

	@Override
	public ResponseEntity<HttpStatus> deleteUser(Long id) {
		User User = userRepository.findOne(id);
		if (User != null) {
			userRepository.delete(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		throw new NotFoundException("User_DOES_NOT_EXIST");
	}

}

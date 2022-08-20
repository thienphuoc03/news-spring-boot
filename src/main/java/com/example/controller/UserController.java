package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;
import com.example.service.impl.UserSeviceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserSeviceImpl userService;

	@GetMapping
	public ResponseEntity<?> getListUser() {
		List<UserDTO> users = userService.getAllUsers();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable long id) {
		UserDTO user = userService.getUserById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createUser() {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser() {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser() {
		return null;
	}
}

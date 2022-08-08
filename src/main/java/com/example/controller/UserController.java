package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.impl.UserSevice;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserSevice userService;

	@GetMapping("")
	public ResponseEntity<?> getListUser() {
		return null;
	}

	@PostMapping("")
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

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CategoryDTO;
import com.example.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping
	public ResponseEntity<?> getListCategory() {
		List<CategoryDTO> categories = categoryService.getAllCategory();
		return ResponseEntity.ok(categories);
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category) {
		return null;
	}

}

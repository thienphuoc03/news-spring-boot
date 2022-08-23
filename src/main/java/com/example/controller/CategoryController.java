package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CategoryDTO;
import com.example.model.Category;
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
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDto) {
		return categoryService.addCategory(categoryDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") Long id,
			@Valid @RequestBody CategoryDTO categoryDto) {
		categoryDto.setId(id);
		return categoryService.updateCategory(categoryDto);
	}

}

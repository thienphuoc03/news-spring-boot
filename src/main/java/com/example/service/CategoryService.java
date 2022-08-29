package com.example.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.dto.CategoryDTO;
import com.example.model.Category;

@Component
public interface CategoryService {
	List<CategoryDTO> getAllCategory();

	ResponseEntity<Category> addCategory(CategoryDTO categoryDto);

	ResponseEntity<Category> updateCategory(CategoryDTO categoryDto);

	ResponseEntity<HttpStatus> deleteCategory(Long id);
}

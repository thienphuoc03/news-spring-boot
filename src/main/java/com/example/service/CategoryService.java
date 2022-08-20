package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.CategoryDTO;

@Component
public interface CategoryService {
	List<CategoryDTO> getAllCategory();
}

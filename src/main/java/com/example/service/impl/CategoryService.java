package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import com.example.mapper.CategoryMapper;
import com.example.repository.CategoryRepository;
import com.example.service.iCategoryService;

@Service
public class CategoryService implements iCategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity category : entities) {
			CategoryDTO categoryDto = categoryMapper.toDto(category);
			result.add(categoryDto);
		}

		return result;
	}

}

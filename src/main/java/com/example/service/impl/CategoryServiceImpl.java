package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CategoryDTO;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryDTO> result = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			CategoryDTO categoryDto = modelMapper.map(categories, CategoryDTO.class);
			result.add(categoryDto);
		}

		return result;
	}

}

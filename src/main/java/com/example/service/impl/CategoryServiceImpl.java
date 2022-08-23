package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.CategoryDTO;
import com.example.exception.NotFoundException;
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
			CategoryDTO categoryDto = modelMapper.map(category, CategoryDTO.class);
			result.add(categoryDto);
		}

		return result;
	}

	@Override
	public ResponseEntity<Category> addCategory(CategoryDTO categoryDto) {
		Category category = new Category();
		modelMapper.map(categoryDto, category);
		Category newCategory = categoryRepository.save(category);

		return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Category> updateCategory(CategoryDTO categoryDto) {
//		Category category = new Category();
		Category oldCategory = categoryRepository.findOne(categoryDto.getId());
		if (oldCategory != null) {
			oldCategory = modelMapper.map(categoryDto, oldCategory.getClass());
			Category updateCategory = categoryRepository.save(oldCategory);
			return new ResponseEntity<>(updateCategory, HttpStatus.OK);
		}

		throw new NotFoundException("CATEGORY_DOES_NOT_EXIST");
	}

}

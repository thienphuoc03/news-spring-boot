package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.CategoryDTO;
import com.example.model.Category;

@Component
public class CategoryMapper {
	public CategoryDTO toDto(Category categoryEntity) {
		CategoryDTO categoryDto = new CategoryDTO();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setCode(categoryEntity.getCode());
		categoryDto.setName(categoryEntity.getName());
		categoryDto.setCreatedBy(categoryEntity.getCreatedBy());
		categoryDto.setCreatedDate(categoryEntity.getCreatedDate());
		categoryDto.setModifiedBy(categoryEntity.getModifiedBy());
		categoryDto.setModifiedDate(categoryEntity.getModifiedDate());

		return categoryDto;
	}
}

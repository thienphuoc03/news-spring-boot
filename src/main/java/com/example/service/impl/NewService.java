package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.NewDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.mapper.NewMapper;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.iNewService;

@Service
public class NewService implements iNewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewMapper newMapper;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newMapper.toEntity(newDTO, oldNewEntity);
		} else {
			newEntity = newMapper.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);

		return newMapper.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity item : entities) {
			NewDTO newDTO = newMapper.toDTO(item);
			results.add(newDTO);
		}

		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item : entities) {
			NewDTO newDTO = newMapper.toDTO(item);
			results.add(newDTO);
		}

		return results;
	}

//	@Override
//	public NewDTO update(NewDTO newDTO) {
//		NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
//		NewEntity newEntity = newMapper.toEntity(newDTO, oldNewEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//		newEntity.setCategory(categoryEntity);
//		newEntity = newRepository.save(newEntity);
//
//		return newMapper.toDTO(newEntity);
//	}
}

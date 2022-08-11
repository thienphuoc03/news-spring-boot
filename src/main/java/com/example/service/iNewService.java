package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.dto.NewDTO;

public interface iNewService {

	List<NewDTO> findAll(Pageable pageable);

	List<NewDTO> findAll();

	int totalItem();

	NewDTO save(NewDTO newDTO);

//	NewDTO update(NewDTO newDTO);
	void delete(long[] ids);

}

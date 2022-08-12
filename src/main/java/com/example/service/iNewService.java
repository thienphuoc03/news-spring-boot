package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.dto.NewDTO;

@Component
public interface iNewService {

	List<NewDTO> findAll(Pageable pageable);

	List<NewDTO> findAll();

	int totalItem();

	NewDTO save(NewDTO newDTO);

//	NewDTO update(NewDTO newDTO);
	void delete(long[] ids);

	List<NewDTO> searchNews(String keyword);

	ResponseEntity<NewDTO> getNews(long id);
}

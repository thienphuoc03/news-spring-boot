package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.dto.NewsDTO;

@Component
public interface NewService {

	int totalItem();

	NewsDTO save(NewsDTO newDTO);

//	NewDTO update(NewDTO newDTO);
	void delete(long[] ids);

	List<NewsDTO> searchNews(String keyword);

	ResponseEntity<NewsDTO> getNews(long id);

	List<NewsDTO> getAllNews(Integer page, Integer size);
}

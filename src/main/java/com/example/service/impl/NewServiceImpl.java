package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.NewsDTO;
import com.example.model.Category;
import com.example.model.News;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.NewService;

@Service
public class NewServiceImpl implements NewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public NewsDTO save(NewsDTO newDTO) {
		News news = new News();
		if (newDTO.getId() != null) {
			News oldnews = newRepository.findOne(newDTO.getId());
			news = modelMapper.map(oldnews, news.getClass());
		} else {
			news = modelMapper.map(newDTO, News.class);
		}
		Category categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		news.setCategory(categoryEntity);
		news = newRepository.save(news);

		return modelMapper.map(news, NewsDTO.class);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> result = new ArrayList<>();
		List<News> listNews = newRepository.findAll(pageable).getContent();
		for (News news : listNews) {
			NewsDTO newDTO = modelMapper.map(news, NewsDTO.class);
			result.add(newDTO);
		}

		return result;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}

	@Override
	public List<NewsDTO> findAll() {
		List<NewsDTO> result = new ArrayList<>();
		List<News> listNews = newRepository.findAll();
		for (News news : listNews) {
			NewsDTO newDTO = modelMapper.map(news, NewsDTO.class);
			result.add(newDTO);
		}

		return result;
	}

	@Override
	public List<NewsDTO> searchNews(String keyword) {
		List<NewsDTO> result = new ArrayList<>();
		List<News> listnews = newRepository.findAll();
		for (News news : listnews) {
			if (news.getTitle().contains(keyword)) {
				NewsDTO newDto = modelMapper.map(listnews, NewsDTO.class);
				result.add(newDto);
			}
		}

		return result;
	}

	@Override
	public ResponseEntity<NewsDTO> getNews(long id) {
		News news = newRepository.findOne(id);
		NewsDTO newDto = modelMapper.map(news, NewsDTO.class);
		return new ResponseEntity<>(newDto, HttpStatus.OK);
	}

//	@Override
//	public NewDTO update(NewDTO newDTO) {
//		news oldnews = newRepository.findOne(newDTO.getId());
//		news news = newMapper.toEntity(newDTO, oldnews);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//		news.setCategory(categoryEntity);
//		news = newRepository.save(news);
//
//		return newMapper.toDTO(news);
//	}
}

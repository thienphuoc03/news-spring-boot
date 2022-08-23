package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NewsDTO;
import com.example.service.NewService;

@RestController
@RequestMapping("/api/news")
public class NewController {

//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	@ResponseBody

	@Autowired
	private NewService newService;

	@GetMapping
	public ResponseEntity<?> getAllNews(@RequestParam(name = "page", required = false, defaultValue = "") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "") Integer size) {
		List<NewsDTO> listNews = newService.getAllNews(page, size);

		return new ResponseEntity<>(listNews, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NewsDTO> getNews(@PathVariable(name = "id") long id) {
		return newService.getNews(id);
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchNews(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
		List<NewsDTO> listNews = newService.searchNews(keyword);

		return new ResponseEntity<>(listNews, HttpStatus.OK);
	}

	@PostMapping
	public NewsDTO createNew(@RequestBody NewsDTO model) {
		return newService.save(model);
	}

	@PutMapping("/{id}")
	public NewsDTO updateNew(@RequestBody NewsDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

}

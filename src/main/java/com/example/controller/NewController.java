package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.example.controller.output.NewOutput;
import com.example.dto.NewDTO;
import com.example.service.iNewService;

@RestController
@RequestMapping("/api/new")
public class NewController {

//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	@ResponseBody

	@Autowired
	private iNewService newService;

	@GetMapping
	public NewOutput showNew(@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "limit", required = false) Integer limit) {
		NewOutput result = new NewOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}

		return result;
	}

	@GetMapping("/search")
	public ResponseEntity<?> searchNews(
			@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
		List<NewDTO> listNews = newService.searchNews(keyword);

		return new ResponseEntity(listNews, HttpStatus.OK);
	}

	@PostMapping
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@PutMapping("/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

}

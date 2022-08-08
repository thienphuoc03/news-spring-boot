package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NewDTO;
import com.example.service.iNewService;

@RestController
@RequestMapping("/api/new")
public class NewController {

//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	@ResponseBody

	@Autowired
	private iNewService newService;

	@GetMapping("")
	public ResponseEntity<?> getListNew() {
		return null;
	}

	@PostMapping("")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@PutMapping("/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping("/new")
	public void deleteNew(@RequestBody long[] ids) {
//		newService.delete(ids);
	}

}

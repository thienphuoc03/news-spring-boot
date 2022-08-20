package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.NewsDTO;
import com.example.model.News;

@Component
public class NewMapper {

	public News toEntity(NewsDTO dto) {
		News entity = new News();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());

		return entity;
	}

	public NewsDTO toDTO(News entity) {
		NewsDTO dto = new NewsDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());

		return dto;
	}

	public News toEntity(NewsDTO dto, News entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());

		return entity;
	}
}

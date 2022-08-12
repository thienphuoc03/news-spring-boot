package com.example.mapper;

import com.example.dto.CommentDTO;
import com.example.entity.CommentEntity;

public class CommentMapper {
	public CommentDTO toDto(CommentEntity commentEntity) {
		CommentDTO commentDto = new CommentDTO();
		commentDto.setId(commentEntity.getId());
		commentDto.setContent(commentEntity.getContent());
		commentDto.setNewId(commentEntity.getNewId());
		commentDto.setUserId(commentEntity.getUserId());
		commentDto.setCreatedBy(commentEntity.getCreatedBy());
		commentDto.setCreatedDate(commentEntity.getCreatedDate());
		commentDto.setModifiedBy(commentEntity.getModifiedBy());
		commentDto.setModifiedDate(commentEntity.getModifiedDate());

		return commentDto;
	}
}

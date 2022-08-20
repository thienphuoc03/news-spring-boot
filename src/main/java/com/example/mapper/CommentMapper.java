package com.example.mapper;

import com.example.dto.CommentDTO;
import com.example.model.Comment;

public class CommentMapper {
	public CommentDTO toDto(Comment commentEntity) {
		CommentDTO commentDto = new CommentDTO();
		commentDto.setId(commentEntity.getId());
		commentDto.setContent(commentEntity.getContent());
		commentDto.setNewId(commentEntity.getNewsId());
		commentDto.setUserId(commentEntity.getUserId());
		commentDto.setCreatedBy(commentEntity.getCreatedBy());
		commentDto.setCreatedDate(commentEntity.getCreatedDate());
		commentDto.setModifiedBy(commentEntity.getModifiedBy());
		commentDto.setModifiedDate(commentEntity.getModifiedDate());

		return commentDto;
	}
}

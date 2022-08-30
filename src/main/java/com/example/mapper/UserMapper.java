package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.UserDTO;
import com.example.model.User;

@Component
public class UserMapper {
	public UserDTO toDto(User userEntity) {
		UserDTO userDto = new UserDTO();
		userDto.setId(userEntity.getId());
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setFullname(userEntity.getFullname());
		userDto.setStatus(userEntity.getStatus());
		userDto.setCreatedBy(userEntity.getCreatedBy());
		userDto.setCreatedDate(userEntity.getCreatedDate());
		userDto.setModifiedBy(userEntity.getModifiedBy());
		userDto.setModifiedDate(userEntity.getModifiedDate());

		return userDto;
	}
}

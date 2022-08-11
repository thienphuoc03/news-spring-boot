package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;

@Component
public class UserMapper {
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO userDto = new UserDTO();
		userDto.setId(userEntity.getId());
		userDto.setUsername(userEntity.getUserName());
		userDto.setPassword(userEntity.getPassword());
		userDto.setFullName(userEntity.getFullName());
		userDto.setStatus(userEntity.getStatus());
		userDto.setCreatedBy(userEntity.getCreatedBy());
		userDto.setCreatedDate(userEntity.getCreatedDate());
		userDto.setModifiedBy(userEntity.getModifiedBy());
		userDto.setModifiedDate(userEntity.getModifiedDate());

		return userDto;
	}
}

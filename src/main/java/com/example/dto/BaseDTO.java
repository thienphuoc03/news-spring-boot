package com.example.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO<T> {

	private Long id;

	private String createdBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	private String modifiedBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedDate;

	private List<T> listResult = new ArrayList<>();

}

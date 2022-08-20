package com.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO extends BaseDTO<NewsDTO> {

	private String title;
	private String content;
	private String shortDescription;
	private String categoryCode;
	private String thumbnail;

}

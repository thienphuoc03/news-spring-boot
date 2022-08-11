package com.example.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseDTO<T> {

	private Long id;

	private String createdBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	private String modifiedBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedDate;

	private List<T> listResult = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
}

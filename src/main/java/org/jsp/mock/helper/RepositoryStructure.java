package org.jsp.mock.helper;

import org.jsp.mock.dto.Employee_dto;

import lombok.Data;

@Data
public class RepositoryStructure<T> {
	String message;
	int statusCode;
	T data;
}

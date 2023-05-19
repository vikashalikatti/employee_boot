package org.jsp.mock.repository;

import java.util.List;

import org.jsp.mock.dto.Employee_dto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employee_repository extends JpaRepository<Employee_dto, Integer> {
	
	List<Employee_dto> findByName(String name);

}

package org.jsp.mock.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.mock.dto.Employee_dto;
import org.jsp.mock.repository.Employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Emplyee_dao {

	@Autowired
	Employee_repository repository;

	public Employee_dto save(Employee_dto dto) {
		// TODO Auto-generated method stub
		return repository.save(dto);
	}

	public List<Employee_dto> fetchall() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Employee_dto fetchbyid(int id) {
		Optional<Employee_dto> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public List<Employee_dto> findbyname(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	public void deleteAll() {
		repository.deleteAll();
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}

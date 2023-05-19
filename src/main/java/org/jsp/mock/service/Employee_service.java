package org.jsp.mock.service;

import java.util.List;
import java.util.Optional;

import org.jsp.mock.dao.Emplyee_dao;
import org.jsp.mock.dto.Employee_dto;
import org.jsp.mock.helper.RepositoryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Employee_service {

	@Autowired
	Emplyee_dao dao;

	public RepositoryStructure<Employee_dto> save(Employee_dto dto) {
		RepositoryStructure<Employee_dto> repositoryStructure = new RepositoryStructure<>();
		repositoryStructure.setMessage("Data Saved Sucessfully");
		repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
		repositoryStructure.setData(dao.save(dto));
		return repositoryStructure;
	}

	public RepositoryStructure<List<Employee_dto>> fetchall() {
		List<Employee_dto> list = dao.fetchall();
		RepositoryStructure<List<Employee_dto>> repositoryStructure = new RepositoryStructure<>();
		if (list.isEmpty()) {
			repositoryStructure.setMessage("No Data To Display");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(null);
		} else {
			repositoryStructure.setMessage("Data Found");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(list);
		}
		return repositoryStructure;

	}

	public RepositoryStructure<Employee_dto> fetchbyid(int id) {

		RepositoryStructure<Employee_dto> repositoryStructure = new RepositoryStructure<>();
		Employee_dto dto = dao.fetchbyid(id);
		if (dto == null) {
			repositoryStructure.setMessage("Data Not Found");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(null);
		} else {
			repositoryStructure.setMessage("Data Found");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(dto);
		}
		return repositoryStructure;
	}

	public RepositoryStructure<List<Employee_dto>> fetchbyname(String name) {
		List<Employee_dto> list = dao.findbyname(name);
		RepositoryStructure<List<Employee_dto>> repositoryStructure = new RepositoryStructure<>();
		if (list.isEmpty()) {
			repositoryStructure.setMessage("No Data To Display");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(null);
		} else {
			repositoryStructure.setMessage("Data Found");
			repositoryStructure.setStatusCode(HttpStatus.CREATED.value());
			repositoryStructure.setData(list);
		}
		return repositoryStructure;
	}

	public RepositoryStructure<Void> deleteById(int id) {
		Optional<Employee_dto> existingEmployee = Optional.ofNullable(dao.fetchbyid(id));

		if (existingEmployee.isPresent()) {
			dao.deleteById(id);
			RepositoryStructure<Void> repositoryStructure = new RepositoryStructure<>();
			repositoryStructure.setMessage("Data deleted successfully");
			repositoryStructure.setStatusCode(HttpStatus.OK.value());
			return repositoryStructure;
		} else {
			RepositoryStructure<Void> repositoryStructure = new RepositoryStructure<>();
			repositoryStructure.setMessage("Employee not found");
			repositoryStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return repositoryStructure;
		}
	}

	public RepositoryStructure<Employee_dto> edit(int id, Employee_dto dto) {
		Optional<Employee_dto> existingEmployee = Optional.ofNullable(dao.fetchbyid(id));

		if (existingEmployee.isPresent()) {
			dto.setId(existingEmployee.get().getId());
			RepositoryStructure<Employee_dto> repositoryStructure = new RepositoryStructure<>();
			repositoryStructure.setMessage("Data updated successfully");
			repositoryStructure.setStatusCode(HttpStatus.OK.value());
			repositoryStructure.setData(dao.save(dto));
			return repositoryStructure;
		} else {
			RepositoryStructure<Employee_dto> repositoryStructure = new RepositoryStructure<>();
			repositoryStructure.setMessage("Employee not found");
			repositoryStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			repositoryStructure.setData(null);
			return repositoryStructure;
		}
	}

	public RepositoryStructure<Void> deleteAll() {
		RepositoryStructure<Void> repositoryStructure = new RepositoryStructure<>();
		dao.deleteAll();
		repositoryStructure.setMessage("All Data Deleted Successfully");
		repositoryStructure.setStatusCode(HttpStatus.OK.value());
		return repositoryStructure;
	}
}

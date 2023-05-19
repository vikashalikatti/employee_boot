package org.jsp.mock.controller;

import java.util.List;

import org.jsp.mock.dto.Employee_dto;
import org.jsp.mock.helper.RepositoryStructure;
import org.jsp.mock.service.Employee_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Employee_controller {

	@Autowired
	Employee_service service;

	@PostMapping("save")
	public RepositoryStructure<Employee_dto> save(@RequestBody Employee_dto dto) {
		return service.save(dto);
	}

	@GetMapping("fetchall")
	public RepositoryStructure<List<Employee_dto>> fetchall() {
		return service.fetchall();
	}

	@GetMapping("fetchid/{id}")
	public RepositoryStructure<Employee_dto> fetchbyid(@PathVariable int id) {
		return service.fetchbyid(id);
	}

	@GetMapping("fetchbyname/{name}")
	public RepositoryStructure<List<Employee_dto>> fetchbyname(@PathVariable String name) {
		return service.fetchbyname(name);
	}

	@DeleteMapping("/delete/{id}")
	public RepositoryStructure<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@DeleteMapping("/deleteall")
	public RepositoryStructure<Void> deleteAll() {
		return service.deleteAll();
	}

	@PutMapping("/edit/{id}")
	public RepositoryStructure<Employee_dto> edit(@PathVariable int id, @RequestBody Employee_dto dto) {
		return service.edit(id, dto);
	}

}

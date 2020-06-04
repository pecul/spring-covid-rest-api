package com.rafi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafi.demo.model.Employee;
import com.rafi.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> employeesList() {
		return employeeRepository.getEmployees();
	}

	@GetMapping(path = "/employees/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee employee(@PathVariable("id") long id) {
		return employeeRepository.getEmployee(id);
	}

	@PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	@PutMapping(path = "/employees/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee, @PathVariable long id) {
		return employeeRepository.updateEmployee(id, employee);
	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteEmployee(id);
	}
}

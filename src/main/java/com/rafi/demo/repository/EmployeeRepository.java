package com.rafi.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rafi.demo.model.Employee;

@Component
public class EmployeeRepository {
	private static final Map<Long, Employee> employees = new HashMap<>();

	public EmployeeRepository() {
		addEmployee(new Employee("Taher", 25));
		addEmployee(new Employee("Rafi", 23));
	}

	public List<Employee> getEmployees() {
		return employees.values().stream().collect(Collectors.toList());
	}

	public Employee getEmployee(long id) {
		return employees.get(id);
	}

	public Employee addEmployee(Employee emp) {
		long id = employees.size() + 1;
		emp.setId(id);
		employees.put(id, emp);

		return getEmployee(id);
	}

	public Employee updateEmployee(long id, Employee emp) {
		if (employees.containsKey(id)) {
			emp.setId(id);
			employees.put(id, emp);
		}

		return getEmployee(id);
	}

	public void deleteEmployee(long id) {
		employees.remove(id);
	}
}

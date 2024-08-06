package com.sodi9.common.employee;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

	private final EmployeeRepository repository;

	EmployeeRestController(EmployeeRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping
	List<Employee> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item

	@GetMapping("{id}")
	Employee one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PutMapping("{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			return repository.save(newEmployee);
		});
	}

	@DeleteMapping("{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}

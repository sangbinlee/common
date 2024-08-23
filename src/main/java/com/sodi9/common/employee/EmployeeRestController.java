package com.sodi9.common.employee;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeRestController {

	private EmployeeService employeeService;
	private EmployeeRepository repository;

	@PostMapping
	public ResponseEntity<Employee> create(@RequestBody Employee employee) {
		Employee employee2 = employeeService.create(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		Employee employee2 = employeeService.update(employee);
		return ResponseEntity.ok(employee2);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> retrive(@PathVariable(name = "id") Long id) {
		Employee employee2 = employeeService.retrive(id);
		if (employee2 == null) {
//			return ResponseEntity.notFound();
		}
		return ResponseEntity.ok(employee2);
	}

//	@GetMapping
//	public ResponseEntity<List<Employee>> findAll() {
//		List<Employee> employee2 = employeeService.findAll();
//		return ResponseEntity.ok(employee2);
//	}



	/**
	 * https://sodi9.store/api/employee/search?size=2&page=1&sort=firstName,desc&sort=id,desc
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<Employee>> search(Pageable pageable, Employee employee) {
		
		ExampleMatcher matcher = ExampleMatcher
				.matching()// and로 조건이 생성
//				.matchingAll()// and로 조건이 생성
//				.matchingAny()// or로 조건문을 생성
				
//                .withIgnoreCase()// 대소문자를 무시
//                .withIgnoreCase("name")// 대소문자를 무시
                
//                .withIgnorePaths("name", "id")// null이 아닌 필드는 무조건 조건으로 생성
                
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)// %Seoul%
//                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.ENDING))// %TEST
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("role", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//		        .withMatcher("name", exact())
		        ; //add filters for other columns here
		    Example<Employee> filter = Example.of(employee, matcher); 
		Page<Employee> employee2 = employeeService.search(filter, pageable);
		return ResponseEntity.ok(employee2);
	}
	
	/**
	 * 1. page, sort 2.
	 * 
	 * @param page
	 * @return
	 */
//	@GetMapping("search")
//	public ResponseEntity<List<Employee>> search(
//			@RequestParam(value = "page", defaultValue = 1) Integer page,
//			
//			) {
//		List<Employee> employee2 = employeeService.retriveAll();
//		return ResponseEntity.ok(employee2);
//	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok("Employee deleted successfully! id=" + id);
	}

	/**
	 * 
	 * @return
	 */

//	private final EmployeeRepository repository;
//	EmployeeRestController(EmployeeRepository repository) {
//		this.repository = repository;
//	}

	// Aggregate root
	// tag::get-aggregate-root[]
//	@GetMapping
//	List<Employee> all() {
//		return repository.findAll();
//	}
	// end::get-aggregate-root[]

//	@PostMapping
//	Employee newEmployee(@RequestBody Employee newEmployee) {
//		return repository.save(newEmployee);
//	}

	// Single item

//	@GetMapping("{id}")
//	Employee one(@PathVariable Long id) {
//
//		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
//	}

//	@PutMapping("{id}")
//	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//		return repository.findById(id).map(employee -> {
//			employee.setName(newEmployee.getName());
//			employee.setRole(newEmployee.getRole());
//			return repository.save(employee);
//		}).orElseGet(() -> {
//			return repository.save(newEmployee);
//		});
//	}

//	@DeleteMapping("{id}")
//	void deleteEmployee(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
}

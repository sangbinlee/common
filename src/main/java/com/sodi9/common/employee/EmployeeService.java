package com.sodi9.common.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sodi9.common.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public Employee create(Employee employee) {
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
	}
	
	public Employee retrive(Long id) {
		Employee employee2 = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("[retrive]Employee is not exists with given id: " + id));
		return employee2;
	}
	

	public List<Employee> retriveAll() {
		List<Employee> employee2 = employeeRepository.findAll();
		employee2
		.stream()
		.map(
				(employee) -> 
//				{
					employee.toString()
//					log.info("employee ={}",employee.toString() )
//				}
				).collect(Collectors.toList());
		return employee2;
	}
	
	public Employee update(Employee employee) {
		
		Long id = employee.getId();
		Employee employee2 = employeeRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("[update]Employee is not exists with given id: " + id)
				);
		
		
		Employee employee3 = employeeRepository.save(employee);
		return employee3;
	}
	
	
	

	public void delete(Long id) {

		Employee employee2 = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("[delete]Employee is not exists with given id: " + id));
		
		employeeRepository.deleteById(id);
	}
	

}
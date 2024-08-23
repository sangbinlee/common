package com.sodi9.common.employee;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
//	Page<Employee> findAll(Pageable pageable);
 

//	@Override
//	List<Employee> findAll(Example<Employee> example, Sort sort);
	
	
//	Page<example> findAll(Example<Employee> example, Pageable pageable);
//	@Override
//	default <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
//		// TODO Auto-generated method stub
////		return null;
//		Page<Employee> findAll(Example<Employee> example, Pageable pageable)
//	}
}
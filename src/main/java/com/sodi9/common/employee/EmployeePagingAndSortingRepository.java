package com.sodi9.common.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Long>, CrudRepository<Employee,Long> {

	  List<Employee> findByFirstName(@Param("firstName") String firstName);
	  
	  List<Employee> findByRole(@Param("role") String role);
	  
	  
}
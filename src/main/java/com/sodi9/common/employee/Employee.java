package com.sodi9.common.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String role;
	private String firstName;
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	public Employee(String name, String role, String firstName, String lastName, String email) {

		this.name = name;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}
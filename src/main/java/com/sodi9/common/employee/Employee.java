package com.sodi9.common.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;

	Employee() {
	}

	Employee(String name, String role) {

		this.name = name;
		this.role = role;
	}

}
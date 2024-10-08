package com.sodi9.common.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
}

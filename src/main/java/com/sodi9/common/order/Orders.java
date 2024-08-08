package com.sodi9.common.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity // This tells Hibernate to make a table out of this class
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private int memberId;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 500, nullable = false)
	private String address;

	@Column(length = 10, nullable = false)
	private String payment;

	@Column(length = 16)
	private String cardNumber;

	@Column(length = 500, nullable = false)
	private String items;

	public Orders(
			int memberId,
			String name, 
			String address, 
			String payment, 
			String cardNumber, 
			String items) {
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.payment = payment;
		this.cardNumber = cardNumber;
		this.items = items;
	}
}

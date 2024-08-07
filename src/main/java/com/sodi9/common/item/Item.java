package com.sodi9.common.item;

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
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String path;

	@Column
	private int price;
	
	@Column
	private int discountPer;

	public Item(String name, String path, int price, int discountPer) {
		this.name = name;
		this.path = path;
		this.price = price;
		this.discountPer = discountPer;
	}
}

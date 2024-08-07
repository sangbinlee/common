package com.sodi9.common.cart;

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
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private int memberId;
	@Column
	private int itemId;

	public Cart(int memberId, int itemId) {
		this.memberId = memberId;
		this.itemId = itemId;
	}
}

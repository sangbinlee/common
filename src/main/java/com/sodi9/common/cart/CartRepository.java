package com.sodi9.common.cart;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface CartRepository extends CrudRepository<Cart, Integer> {
	Cart findByItemIdAndItemId(int memberId, int itemId);

	List<Cart> findByMemberId(int memberId);

}
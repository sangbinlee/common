package com.sodi9.common.item;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
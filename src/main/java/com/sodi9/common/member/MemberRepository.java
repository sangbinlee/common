package com.sodi9.common.member;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface MemberRepository extends CrudRepository<Member, Integer> {
	Member findByEmailAndPassword(String email, String password);

}
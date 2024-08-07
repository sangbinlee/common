package com.sodi9.common.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sodi9.common.employee.Employee;
import com.sodi9.common.employee.EmployeeRepository;
import com.sodi9.common.item.Item;
import com.sodi9.common.item.ItemRepository;
import com.sodi9.common.member.Member;
import com.sodi9.common.member.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(
			EmployeeRepository employeeRepository
			, MemberRepository memberRepository
			, ItemRepository itemRepository
			) {

		return args -> {
//			log.info("Preloading " + employeeRepository.save(new Employee("Bilbo Baggins", "burglar")));
//			log.info("Preloading " + employeeRepository.save(new Employee("Frodo Baggins", "thief")));
//			
//			
//			log.info("Preloading " + memberRepository.save(new Member("sangbinlee9@gmail.com", "pwd1234", "이상빈")));
//			log.info("Preloading " + memberRepository.save(new Member("하나님@gmail.com", "pwd1234", "하나님")));
//			
//
//			log.info("Preloading " + itemRepository.save(new Item("ai-generated-8723974_640.png", "/src/assets/img/", 1000000, 10)));
//			log.info("Preloading " + itemRepository.save(new Item("istockphoto-155144963-1024x1024.jpg", "/src/assets/img/", 1000000, 10)));
//			log.info("Preloading " + itemRepository.save(new Item("starry-8450454_640.jpg", "/src/assets/img/", 1000000, 10)));
//			log.info("Preloading " + itemRepository.save(new Item("starry-night-1093721_640.jpg", "/src/assets/img/", 1000000, 10)));
			
			
		};
	}
}
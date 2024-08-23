package com.sodi9.common.init;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.sodi9.common.employee.Employee;
import com.sodi9.common.employee.EmployeeRepository;
import com.sodi9.common.item.ItemRepository;
import com.sodi9.common.member.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(
			EmployeeRepository employeeRepository, MemberRepository memberRepository, ItemRepository itemRepository) {

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

//			for (int i = 0; i < 99; i++) {
//				Employee employee = new Employee("name-" + i, Integer.toString(i) ,  "firstName" + i,  "lastName" + i , "firstName" + i + "@gmail.com");
//				log.info("Preloading " + employeeRepository.save(employee));
//			}

		};
	}

//	@Bean
//	ApplicationRunner initDatabase2(
//			EmployeeRepository employeeRepository, MemberRepository memberRepository, ItemRepository itemRepository) {
//
//		return args -> { 
//
//			for (int i = 0; i < 9; i++) {
//				Employee employee = new Employee("22name-" + i, Integer.toString(i) ,  "22firstName" + i,  "22lastName" + i , "22firstName" + i + "@gmail.com");
//				log.info("22Preloading " + employeeRepository.save(employee));
//			}
////			employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);
////			employeeRepository.findAll(Sort.by(Sort.Order.desc("id"))).forEach(System.out::println);
////			employeeRepository
////				.findAll(Sort.by(
////									Sort.Order.desc("id")
////									, Sort.Order.asc("name")
////								)
////				).forEach(System.out::println);
//			employeeRepository.findAll(PageRequest.of(0, 5)).forEach(System.out::println);
//			System.out.println("---------------------------");
//			employeeRepository.findAll(PageRequest.of(1, 5)).forEach(System.out::println);
//			System.out.println("---------------------------");
//			employeeRepository.findAll(PageRequest.of(0, 6, Sort.by(Sort.Order.desc("id")))).forEach(System.out::println);
//		};
//	}
	
	
}
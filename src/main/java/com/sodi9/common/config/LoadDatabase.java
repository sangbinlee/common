package com.sodi9.common.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sodi9.common.member.Member;
import com.sodi9.common.employee.EmployeeRepository;
import com.sodi9.common.employee.Employee;
import com.sodi9.common.member.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository, MemberRepository memberRepository) {

		return args -> {
			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
			log.info("Preloading " + memberRepository.save(new Member("sangbinlee9@gmail.com", "pwd1234", "이상빈")));
			log.info("Preloading " + memberRepository.save(new Member("하나님@gmail.com", "pwd1234", "하나님")));
		};
	}
}
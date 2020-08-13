package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.demo.persistence.repo.PersonRepo;

@SpringBootApplication
public class CustomQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(CustomQueriesApplication.class, args);
		PersonRepo repo = ac.getBean(PersonRepo.class);
		System.out.println(repo.findAllJPQL());
		System.out.println(repo.findPersonByName("Jordan Harrison"));
		System.out.println(repo.findPersonByNameAndAge("Jordan Harrison", 26));
		System.out.println(repo.findPersonByAgeGreaterThan(25));
		System.out.println(repo.findPersonByAgeLessThan(26));
		System.out.println(repo.findPersonByNameIsNull());
		System.out.println(repo.findPersonByNameIsNotNull());
		System.out.println(repo.findPersonByNameSQL("Jordan Harrison"));
		System.out.println(repo.findPersonByNameAndAgeSQL("Jordan Harrison", 26));
	}

}

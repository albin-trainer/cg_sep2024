package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Main.class, args);
		//addStudent();
		EmpRepo repo=ctx.getBean(EmpRepo.class);
		//repo.addStudent();
	//	repo.removeStudent();
		repo.print();
	}


}

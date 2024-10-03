package com.cg.pack1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication//@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
@ComponentScan(basePackages = "com.cg")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		 //creates ApplicationContext instance +starts the tomcat server +
		//+based on the class path spring container initializes the components
		//returns ApplicationContext
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
	}

}

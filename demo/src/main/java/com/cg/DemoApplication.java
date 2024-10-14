package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(DemoApplication.class, args);
		LoginService service=ctx.getBean(LoginService.class);
//		User user=new User();
//		user.setUserName("Gokul");
//		user.setPassword("cg");
//		service.register(user);
		service.login("Gokul", "cg");
	}
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder(15);
	}
	
}

package com.cg.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Client {
	public static void main(String[] args) {
		
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("beans.xml");
		
		System.out.println("spring ioc initialized");
		AccountService service=(AccountService) ctx.getBean("service");
		System.out.println(service.creditService(10000));
	}
}

package com.cg.bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("spring ioc container initialized ....");
		GreetingBean bean1= (GreetingBean) ctx.getBean("greet");
		GreetingBean bean2= (GreetingBean) ctx.getBean("greet");
		System.out.println(bean1==bean2); //chks the memory
		//System.out.println(bean.sayHello("Albin"));
	}
}

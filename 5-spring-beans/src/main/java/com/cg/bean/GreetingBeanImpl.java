package com.cg.bean;

import java.util.List;

//Spring is gona to make this obj
public class GreetingBeanImpl implements GreetingBean {
 private String msg;
 public GreetingBeanImpl(int a) {
	System.out.println("constructor ....."+a);
}
 //spring injects a msg here ...
 public void setMsg(String msg) {
	 System.out.println("setter .....");
	 this.msg=msg;
 }
	public String sayHello(String name) {
		return "Hello "+name+" "+msg;
	}
	
	public void setListNames(List<String> list) {
		 System.out.println("setter .....");
		 System.out.println(list);	
}
}

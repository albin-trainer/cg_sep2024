package com.cg;

import java.util.Scanner;

public class ClassLoadDemo {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	//here before compilation we know this is the obj to create
	//new SampleDemo();
	//if @run time we get to know the class 
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the class name");
	String className=scanner.next();
	//jvm has to load the class @ runtime
	Class c=Class.forName(className);
	System.out.println("class loaded in JVM");
	c.newInstance();
	
}
}

class SampleDemo{
	public SampleDemo() {
		System.out.println("constructor");
	}
}
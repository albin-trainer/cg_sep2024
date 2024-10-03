package com.cg.exceptions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
public static void main(String[] args) {
	//Stream.of("Apple","Orange","Grapes","Banana").mapToInt(null)
	
	List<Integer> list1=Arrays.asList(10,20,30,40,50);
	//.stream() ==>Object Stream
	//IntStream, DoubleStream,LongStream ==>supports primitives v can find sum(),average
	long s=list1.stream().
			mapToInt(i->i*2).sum();
	System.out.println(s);
	Product p1= new Product(1, "Apple", 200);
	Product p2= new Product(2, "Orange", 100);
	Product p3= new Product(3, "Grapes", 150);
	Product p4= new Product(4, "Banana", 90);
	Product p5= new Product(5, "Mango", 250);
	List<Product> list2=Arrays.asList(p1,p2,p3,p4,p5);
	double totalPrice=
	list2.stream().filter(p->p.getPrice()>=100).mapToDouble(p->p.getPrice()).sum();
	System.out.println(totalPrice);
	
	Comparator<Product> findMax= (it1,it2)-> it1.getPrice()<it2.getPrice()?-1:1;
	
	Product max=
	list2.stream().max( findMax ).get();
	System.out.println(max.getName());
	
	Product min=
			list2.stream().min( (it1,it2)-> it1.getPrice()<it2.getPrice()?-1:1 ).get();
			System.out.println(min.getName());
}
}

class Product{
	int id;
	String name;
	float price;
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	
}

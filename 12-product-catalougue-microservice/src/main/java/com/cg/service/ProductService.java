package com.cg.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.cg.entity.Product;
@Service
public class ProductService {
	@Autowired
	private Environment env;
 List<Product> list=new ArrayList<>();
 public List<Product> allProducts(){
	 String port=env.getProperty("local.server.port");
	 
	 list.add(new Product(101,"TShirt",1000,port));
	 list.add(new Product(102,"Mobile",10000,port));
	 list.add(new Product(103,"TV",50000,port));
	 list.add(new Product(104,"Laptop",60000,port));
	 return  list;
 }
}

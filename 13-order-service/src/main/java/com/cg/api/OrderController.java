package com.cg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entity.Order;
import com.cg.proxy.ProductServiceProxy;

@RestController
public class OrderController {
@GetMapping("/order/{pid}/{quantity}")
	public ResponseEntity<Order> orderProducts(@PathVariable int pid,@PathVariable int quantity){
	String url="http://localhost:8000/products/"+pid;
	
	  RestTemplate template= new RestTemplate();
	  Order order=  template.getForObject(url, Order.class);
	  order.setPrice(order.getPrice()*quantity);
	  order.setQuantity(quantity);
		return new  ResponseEntity<Order>(order,HttpStatus.OK);
	}
@Autowired
private RestTemplate restTemplate;
@GetMapping("/loadbalance/order/{pid}/{quantity}")
public ResponseEntity<Order> orderProductsWithLoadBalance(@PathVariable int pid,@PathVariable int quantity){
String url="http://product-catalougue/products/"+pid;
  //RestTemplate template= new RestTemplate();
  Order order=  restTemplate.getForObject(url, Order.class);
   //restTemplate
  order.setPrice(order.getPrice()*quantity);
  order.setQuantity(quantity);
	return new  ResponseEntity<Order>(order,HttpStatus.OK);
}
@Autowired
private ProductServiceProxy proxy;
@GetMapping("/feign/order/{pid}/{quantity}")
public ResponseEntity<Order> orderByFeign(@PathVariable int pid,@PathVariable int quantity){
    //this developer not even know that he is calling a service
	Order order=proxy.orderProduct(pid);
	return new  ResponseEntity<Order>(order,HttpStatus.OK);
}
}

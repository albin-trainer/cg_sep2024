package com.cg.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/hello")
public String hello() {
	return "Hello";
}
	
	@GetMapping("/home")
public String home() {
	return "HOME PAGE";
}
	
	@GetMapping("/home/add")
public String add() {
	return "ADD PAGE By ADMIN";
}
}

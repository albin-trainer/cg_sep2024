package com.cg.beans;

import org.springframework.stereotype.Component;
@Component
public class SavingsAccRepo implements AccountRepository{
	public SavingsAccRepo() {
		System.out.println("constructor of savings acc repo");
	}
	@Override
	public String credit(float amt) {
		return "Hi the amt of "+amt +" credited in ur savings acc";
	}
}

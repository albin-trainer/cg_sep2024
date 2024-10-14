package com.cg.service;
public class CalculatorService {
	
	public int add(int x, int y) {
		return x+y;
	}
	public int div(int x, int y) {
		if(y==0)
			throw new RuntimeException("Cant divide by zero");
		return x/y;
	}
}

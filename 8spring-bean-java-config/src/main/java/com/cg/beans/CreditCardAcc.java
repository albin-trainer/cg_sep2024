package com.cg.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
public class CreditCardAcc implements AccountRepository {

	@Override
	public String credit(float amt) {
		// TODO Auto-generated method stub
		return "hello in ur credit card "+amt +" is credited";
	}

}

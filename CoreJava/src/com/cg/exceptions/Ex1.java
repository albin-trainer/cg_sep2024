package com.cg.exceptions;

import java.time.LocalDate;

public class Ex1 {
	float balanceAmt=5000;
public static void main(String[] args) {
	Ex1 e=new Ex1();
	//String msg=e.debit(4000);
	//System.out.println(msg);
	LocalDate date=LocalDate.of(2024,10, 4);
	String s=e.checkDate(date);
	System.out.println(s);
}
// if the date comes on week ends (Sunday/Saturday) throw exception
String checkDate(LocalDate date) {
	//System.out.println(date.getDayOfWeek());
	String weekDay=date.getDayOfWeek().toString();
	try {
		if (weekDay.equals("SATURDAY") || weekDay.equals("SUNDAY")) {
			throw new InvalidInputException("ITS WeekEND");
		} 
	} catch (Exception e) {
		return e.getMessage();
	}
	return weekDay;
}
 String debit(float amt) {
	 try {
	if(amt<=balanceAmt) {
		balanceAmt=balanceAmt-amt;
		return "Transaction success ur balance amt s "+amt;
	}
	else
		throw new InvalidInputException("Insufficient funds");
	 }
	 catch(Exception e) {
		 return e.getMessage();
	 }
}
}


class InvalidInputException extends RuntimeException{
	InvalidInputException(String s){
		super(s);
	}
}
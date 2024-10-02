package com.cg.beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
public class AccountServiceImpl implements AccountService {
	@Autowired
	//@Qualifier("savings")
	private AccountRepository accRepo=null;
	public AccountServiceImpl() {
		System.out.println("constructor of acc service");
	}
	//here spring injected the savingsAccRep bean here....
////	@Autowired
//	public void setAccRepository(AccountRepository accRepo) {
//		System.out.println("setter of acc service");
//		this.accRepo = accRepo;
//	}
	
	public String creditService(float amt) {
		return accRepo.credit(amt);
	}
}

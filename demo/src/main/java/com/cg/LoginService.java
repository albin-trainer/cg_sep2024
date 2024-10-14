package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginService {
	@Autowired
  private UserRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public void register(User user) {
		//save in the DB
		String encoded=passwordEncoder.encode(user.getPassword());
		user.setPassword(encoded);
		repo.save(user);
		System.out.println("saved");
	}
	public void login(String uname,String pwd) {
		User u=repo.findById(uname).get();
		
		if( passwordEncoder.matches(pwd,u.getPassword())) {
			System.out.println("Success");
		}
		else
			System.out.println("Failed...");
		
	}
	
}

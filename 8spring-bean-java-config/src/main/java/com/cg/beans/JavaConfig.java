package com.cg.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
//Replaced beans.xml
@Configuration
@ComponentScan(basePackages = "com.cg")
//@ImportResource("beans.xml")
public class JavaConfig {
	@Bean("service")
	public AccountServiceImpl getAccService() {
		return new AccountServiceImpl();
	}
	/*
	 * @Bean//("savings") public SavingsAccRepo getSavings() { return new
	 * SavingsAccRepo(); }
	 */
}

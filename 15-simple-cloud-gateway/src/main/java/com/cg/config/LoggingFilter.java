package com.cg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class LoggingFilter implements GlobalFilter {
	//log from sl4j 
	Logger log=LoggerFactory.getLogger(getClass().getName());
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("****Logging****");
		log.info("got req for " +exchange.getRequest().getURI());
		return chain.filter(exchange);
	}



}

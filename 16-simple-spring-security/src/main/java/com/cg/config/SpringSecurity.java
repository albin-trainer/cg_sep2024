package com.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	 @Bean public PasswordEncoder passwordEncoder() {
		  return NoOpPasswordEncoder.getInstance();
	  }
	@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Albin")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build());
        manager.createUser(User.withUsername("user1")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build());
            
        manager.createUser(User.withUsername("user2")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build());
        manager.createUser(User.withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build());
        return manager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests()
               .requestMatchers("/home/add/**").hasRole("ADMIN")
               .requestMatchers("/home/**").hasAnyRole("ADMIN","USER")
                .requestMatchers("/").permitAll()
                .and()
                .formLogin();
        return http.build();
    }
   
}

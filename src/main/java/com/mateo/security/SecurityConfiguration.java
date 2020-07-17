package com.mateo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//set your configuration on auth obj
		
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("pass")
		.roles("roles");
		
	}
	
  @Override
	protected void configure(HttpSecurity http) throws Exception {
	     http       //other configure params.
	         .csrf().disable();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}

}

package com.javabrains.sprintbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

//	authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("blah")
			.password("blah")
			.roles("USER")
			.and()
			.withUser("foo")
			.password("foo")
			.roles("ADMIN");
		
	}
	
//	authorization
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//	   "/**" will represent all URI's, to permit all unauthenticated users to all uri's use antMatchers("/**").permitAll()
		
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin").hasRole("ADMIN") // only admin will have access
			.antMatchers("/user").hasAnyRole("USER","ADMIN") // only admin ,user role will have access			
			.and().formLogin();	
		
	}

}

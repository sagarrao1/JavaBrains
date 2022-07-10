package com.javabrains.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	DataSource dataSource; 
	
//	@Autowired
//	UserDetailsService userDetailsService;
	
//	authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication()
        	.userDnPatterns("uid={0},ou=people")
        	.groupSearchBase("ou=groups")
        	.contextSource()
        	.url("ldap://localhost:8389/dc=springframework,dc=org")
        	.and()
        	.passwordCompare()
        	.passwordEncoder(new BCryptPasswordEncoder())
        	.passwordAttribute("userPassword");
	
	
	}

//	Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.anyRequest().authenticated()
//			.antMatchers("/admin").hasRole("ADMIN")
//			.antMatchers("/user").hasAnyRole("USER","ADMIN")
//			.antMatchers("/").permitAll()
			.and().formLogin();	
	}
	
	
//	@Bean
//	public PasswordEncoder getPasscode() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
}

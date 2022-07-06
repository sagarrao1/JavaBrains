package com.javabrains.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfiguration_New {

//	authentication
	
	@Autowired
	DataSource dataSource;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//			.dataSource(dataSource);
			
//			we don't need below as we have created default and tables using schema.sql and data.sql
//			.withDefaultSchema()
//			.withUser(
//					User.withUsername("user")
//						.password("pass")
//						.roles("USER")					
//			 )						
//			.withUser(
//					User.withUsername("admin")
//						.password("admin123")
//						.roles("ADMIN")					
//			 );			
			
//	}	
	

//	authorization	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMIN","USER")
			.and().formLogin();
		
		http.headers().frameOptions().sameOrigin();
		 
        return http.build();
	}
	
	
//	to tell that we are not using hasing password NoopPassordEncoder	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();		
	}
	

}

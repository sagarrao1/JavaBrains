package com.javabrains.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	authentication
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource);
			
//		to use sql queries if table names are different		
//			.usersByUsernameQuery("select username, password, enabled from users where username= ?")
//			.authoritiesByUsernameQuery("select username, authority from authorities where username= ?");
			
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
			
	}	
	

//	authorization	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/user").hasRole("USER")
			.antMatchers("/admin").hasAnyRole("ADMIN","USER")
			.and().formLogin();
	}
	
	
//	to tell that we are not using hasing password NoopPassordEncoder	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();		
	}
	

}

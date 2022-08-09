package com.javabrains.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.DbSettings;

@RefreshScope
@RestController
public class GreetingController {
	
	@Value("this some static message")
	private String staticMsg;
	
	@Value("${my.greeting: default value}")
	private String greeting;
	
	@Value("${listValues}")
	private List<String> values;
	
	@Value("${app.description}")
	private String appDesc;
	
	@Value("#{${connection}}")
	private Map<String, String> mapValues;

	@Autowired
	private DbSettings dbSettings;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/greeting")
	@RefreshScope
	public String getGreeting() {
		System.out.println(dbSettings );

//		return greeting	+ " | "+
//				staticMsg+ " | "+
//				appDesc+ " | "+
//				mapValues+ " | "+
//				values;

		return dbSettings.getValues() + dbSettings.getHost() + dbSettings.getPort() + " | list of values: "+values;
//		return greeting; 
	}
	
	@RequestMapping("/envdetails")
	public String envdetails() {
		
		return env.toString();
	}

}

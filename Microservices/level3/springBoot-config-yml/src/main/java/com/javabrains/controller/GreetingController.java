package com.javabrains.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.DbSettings;

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
	
	@RequestMapping("/greeting")
	public String getGreeting() {
//		return greeting	+ " | "+
//				staticMsg+ " | "+
//				appDesc+ " | "+
//				mapValues+ " | "+
//				values;

		System.out.println(dbSettings);
		return dbSettings.getValues() + dbSettings.getHost() + dbSettings.getPort();
	}

}

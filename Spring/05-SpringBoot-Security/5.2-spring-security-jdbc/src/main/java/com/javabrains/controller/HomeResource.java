package com.javabrains.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String getPage() {
		return "<h1> Welcome page using JDBC </h1>";
	}

	@GetMapping("/user")
	public String getUserPage() {
		return "<h1> Welcome JDBC user </h1>";
	}

	@GetMapping("/admin")
	public String getAdminPage() {
		return "<h1> Welcome JDBC admin</h1>";
	}
}

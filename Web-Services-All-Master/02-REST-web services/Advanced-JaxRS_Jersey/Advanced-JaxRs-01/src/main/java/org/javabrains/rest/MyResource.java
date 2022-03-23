package org.javabrains.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class MyResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "test method"; 
	}

}

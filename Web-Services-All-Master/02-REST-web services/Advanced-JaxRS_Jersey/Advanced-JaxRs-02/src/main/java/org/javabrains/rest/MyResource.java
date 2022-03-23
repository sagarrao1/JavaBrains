package org.javabrains.rest;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
@Singleton
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		count++;
		return "test method. count is increased to "+count+" times"; 
	}

}

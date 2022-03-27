package org.javabrains.rest.basicAuthentication;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("secure")
public class SecureResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "this is secure API page"; 
	}

}

/* uri */ 
/*	http://localhost:8080/Advanced-JaxRs-07/webapi/secure */
package org.javabrains.rest.basicAuthentication;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("secured")
public class SecureResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "this is secure API page  !"; 
	}

}

/* uri */ 
/*	http://localhost:8080/Advanced-JaxRs-07/webapi/secured/message */
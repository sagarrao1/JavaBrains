package org.javabrains.rest;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {
	
	@PathParam("pathParam") String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "test method pathParam printed using: "+pathParamExample+" and query param printed using "
				+ queryParamExample; 
	}
	
	/* Below is url */
	/*
	 * http://localhost:8080/Advanced-JaxRs-03/webapi/path/test?query=queryValue
	 */
}

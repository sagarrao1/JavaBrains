package org.javabrains.resource;

import org.javabrains.model.MyDate;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/date/{dateString}")
public class DateResource {
	
	
	@GET	
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("dateString") MyDate dateString) {
		return "Got "+dateString;
	}
	

}

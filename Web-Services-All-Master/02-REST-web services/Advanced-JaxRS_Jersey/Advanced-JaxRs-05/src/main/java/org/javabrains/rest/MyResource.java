package org.javabrains.rest;

import java.util.Calendar;
import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("test")
public class MyResource {
	
	
//	MessageBodyWriter example
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public Date testMessageBodyWriter() {
//		return Calendar.getInstance().getTime(); 
//	}

	
//	Custom MediaType example
	
	@GET
	@Produces(value = {  MediaType.TEXT_PLAIN,  "text/shortdate"})
	public Date customMediaType() {
		System.out.println(Calendar.getInstance().getTime());
		return Calendar.getInstance().getTime(); 
	}
	
	
	/* url */ 
/*	http://localhost:8080/Advanced-JaxRs-05/webapi/test */
	
}

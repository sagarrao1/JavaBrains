package org.javabrains.rest.filter;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter{

	

	// Request
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Request filter : ");
		System.out.println("Headers " + requestContext.getHeaders());
		
	}

	// Response
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Response filter : ");
		System.out.println("Headers " + requestContext.getHeaders());
		
	}

}

package org.javabrains.rest.basicAuthentication;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.Provider;


@Provider
public class SecureFilter implements ContainerRequestFilter{
	
	public static final String AUTHORIZARION_HEADER_KEY="Authorization";
	public static final String AUTHORIZARION_HEADER_PREFIX="Basic ";
	public static final String SECURE_URI_PREFIX="secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("SecureFilter");
		
		List<String> authHeaderList = requestContext.getHeaders().get(AUTHORIZARION_HEADER_KEY);
		
		if (requestContext.getUriInfo().getPath().contains(SECURE_URI_PREFIX)) {		
			if ( authHeaderList != null && authHeaderList.size() > 0) {
			String authToken = authHeaderList.get(0);
			System.out.println("authToken : "+authToken);
			authToken = authToken.replaceFirst(AUTHORIZARION_HEADER_PREFIX,"");
			System.out.println("authToken : "+authToken);
			byte[] decodedBytes = Base64.getDecoder().decode(authToken);
			String decodedString = new String(decodedBytes);
			System.out.println("decodedString : "+decodedString);
			StringTokenizer stringTokenizer= new StringTokenizer(decodedString, ":");
			System.out.println("stringTokenizer : " +stringTokenizer.toString());
			String userName = stringTokenizer.nextToken();
			System.out.println("userName : "+userName);
			String password = stringTokenizer.nextToken();
			System.out.println("password : "+password);
			
			if ("user".equalsIgnoreCase(userName) && "password1555".equals(password)) {
				return ;
			}			
			
		}
			Response unAuthorizedResponse = Response.status(Status.UNAUTHORIZED)
					.entity(" UnAurhorized acesss due to invalid login credentials. User can't access ")
					.build();
			
			requestContext.abortWith(unAuthorizedResponse);
		
	   }	
	}

}

package com.javabrains.messenger.resources;

import java.net.URI;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes({MediaType.TEXT_PLAIN})
@Produces({MediaType.TEXT_PLAIN})
public class InjectDemoResource {

	
//	http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value
	@GET
	@Path("annotations")
	public String getparamsusingAnnotation(@MatrixParam("param") String matrixparam,
										   @HeaderParam("customHeadervalue") String header,
										   @CookieParam("name") String name) {
		return "matrixparam : "+matrixparam +"\n customHeadervalue : "+header +"\n cookie name: "+name;
	}
	
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "path : "+path +"\n cookies :"+cookies;
	}
}

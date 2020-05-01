package com.resteasy.practice.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	//@HeaderParam : we can send custom values in the header 
	//which can be used in authentication or security point of view 
	 // e.g custom param : authSessionID. , here we need to know the name of param to get the actual value
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("authSessionID") String header,
											@CookieParam("CookieName") String cookie) {
		return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
	}
	
	//@Context : If we have more than one header/cookie params then instead of having all the params as an input 
	//we use @Context to get hold of all Header/Cookie params 
	
	// @Context can be annotated/injected using two types UriInfo , HttpHeaders
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context  UriInfo uriInfo, @Context HttpHeaders headers) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path : " + path + " Cookies: " + cookies;
	}
	
	
	

}

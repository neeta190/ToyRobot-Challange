package com.toy.robot.rest.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * This class is used to implement filter to allow Cross Origin Request.
 *
 */

@Provider
public class RobotCorsFilter implements ContainerResponseFilter {

	/*
	 * The filter method is overridden to implement the abstract
	 * method provided by ContainerResponseFilter Interface to support CORS
	 * 
	 * @Param conReqContext   ContainerRequestContext Object
	 * @Param conResContext   ContainerResponseContext Object
	 */
    public void filter(ContainerRequestContext conReqContext,
    		ContainerResponseContext conResContext) {

    	conResContext.getHeaders().add("Access-Control-Allow-Origin", "*");
    	conResContext.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
    	conResContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    	conResContext.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");

    }

	
}

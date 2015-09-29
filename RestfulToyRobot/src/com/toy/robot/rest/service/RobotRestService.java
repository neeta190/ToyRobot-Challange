package com.toy.robot.rest.service;

import javax.ws.rs.core.Response;


import com.toy.robot.inout.InputOutput;
import com.toy.robot.exception.CustomException;

/**
 * This is an interface that exposes the robot behavior 
 * as service.
 *
 */
public interface RobotRestService {
	
	/*
	 * This is a abstract service method that creates the robot.
	 * 
	 * @Param name   Robot name
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	public Response create(String name) throws CustomException;
	
	/*
	 * This is a abstract service method that returns the list of 
	 * robots that has been created.
	 * 
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	public Response list() throws CustomException;
	
	/*
	 * This is a abstract service method places the created robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Param input   InputOutput Object
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	public Response place(InputOutput input, String name) throws CustomException;
	
	/*
	 * This is a abstract service method which guides the movement of the created 
	 * robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Param command   String that guides the movement i.e left, right, move
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	public Response change(String name, String command) throws CustomException;
	
	/*
	 * This is a abstract service method which reports the position of the created 
	 * robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	public Response Report(String name) throws CustomException;

}

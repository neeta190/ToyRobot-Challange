package com.toy.robot.rest.service;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.toy.robot.enums.ChangePosition;
import com.toy.robot.factory.RobotFactoryImpl;
import com.toy.robot.factory.RobotFactoryIntf;
import com.toy.robot.inout.InputOutput;
import com.toy.robot.inout.RobotNameList;
import com.toy.robot.main.RobotIntf;
import com.toy.robot.main.RobotPosition;
import com.toy.robot.exception.CustomException;
import com.toy.robot.store.RobotStore;
import com.toy.robot.store.RobotStoreImpl;

/**
 * This is an implementation class that exposes the robot behavior 
 * as service.
 *
 */

@Path("/robot")
public class RobotServiceImpl implements RobotRestService{
	
	RobotStore roboStore = new RobotStoreImpl();

	/*
	 * This is a service method that creates the robot.
	 * 
	 * @Param name   Robot name
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	
	@POST
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response create( @PathParam("name") String name ) throws CustomException {
		if(name.trim().equals("") || name.equals("\"\""))
			throw new CustomException("Empty String as Robot Name is not allowed");
		
		if(roboStore.checkForRobotExistanceInStore(name) != null)
		{
			return Response.status(Status.SEE_OTHER).build();
		} else{
			
			RobotFactoryIntf robofactory = new RobotFactoryImpl();
			RobotIntf robot = robofactory.create(name);
			roboStore.addRobots(robot);
		}
		return Response.ok().build();
	}	
	
	/*
	 * This is a service method that returns the list of 
	 * robots that has been created.
	 * 
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() throws CustomException {
			
		RobotNameList resultantList = new RobotNameList();
		resultantList.setRobotNameList(roboStore.listRobots());
		return Response.ok(resultantList, MediaType.APPLICATION_JSON).build();
	}
	
	/*
	 * This is a service method places the created robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Param input   InputOutput Object
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	
	@POST
	@Path("/{name}/position")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response place( InputOutput input, @PathParam("name") String name) throws CustomException{

		RobotIntf robot = roboStore.checkForRobotExistanceInStore(name);
		if( robot == null )
		{
			throw new CustomException("Robot not placed on platform yet");
		}
		else
			robot.place(input.getAngle(), input.getX_pos(), input.getY_pos());
			
		return Response.ok(setInputOutputBean(robot.getRoboPosition()), MediaType.APPLICATION_JSON).build();
		}
	
	
	/*
	 * This is a service method which guides the movement of the created 
	 * robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Param command   String that guides the movement i.e left, right, move
	 * @Return Response   Response Object
	 * @throws CustomException 
	 */
	
	@PUT
	@Path("/{name}/position/{command}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response change( @PathParam("name") String name, @PathParam("command") String command) throws CustomException
	{
		RobotIntf robot = roboStore.checkForRobotExistanceInStore(name);
		if( robot == null || robot.getRoboPosition() == null)
				throw new CustomException("Either Robot not placed on platform or Robot is not created");
		else {
			ChangePosition pos = ChangePosition.valueOf(command.toUpperCase());
			switch(pos){
				case LEFT :
					robot.left();
					break;
				case RIGHT :
					robot.right();
					break;
				case MOVE :
					robot.move();
					break;
			}
		}
		return Response.ok(setInputOutputBean(robot.getRoboPosition()), MediaType.APPLICATION_JSON).build();
	}
	
	
	/*
	 * This is a service method which reports the position of the created 
	 * robot on the platform.
	 * 
	 * @Param name   Robot name
	 * @Return Response  Response Object
	 * @throws CustomException 
	 */
	
	@GET
	@Path("/{name}/position")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Report( @PathParam("name") String name ) throws CustomException{
	
		RobotIntf robot = roboStore.checkForRobotExistanceInStore(name);
		if( robot == null)
		{
			throw new CustomException("Robot not yet created");
		}
		else if(robot.getRoboPosition() == null)
			return Response.status(Status.NO_CONTENT).build();
			
		return Response.ok(setInputOutputBean(robot.getRoboPosition()), MediaType.APPLICATION_JSON).build();
	}
	
	/*
	 * This method is used to set the robot position to the InputOutput bean.
	 * .
	 * 
	 * @Param RobotPosition  RobotPosition Object
	 * @Return InputOutput    InputOutput Object
	 */
	private InputOutput setInputOutputBean(RobotPosition roboPosition)
	{
		InputOutput inout = new InputOutput();
		inout.setAngle(roboPosition.getAngle().name());
		inout.setX_pos(roboPosition.getX_pos());
		inout.setY_pos(roboPosition.getY_pos());
			
		return inout;
	}
}

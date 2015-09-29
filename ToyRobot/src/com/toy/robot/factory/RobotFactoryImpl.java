package com.toy.robot.factory;


import com.toy.robot.main.RobotImpl;
import com.toy.robot.main.RobotIntf;
import com.toy.robot.main.RobotPlatform;

/**
 * This is a robot factory implementation that creates the 
 * instances of robot class on demand.
 *
 */
public class RobotFactoryImpl implements RobotFactoryIntf{
	
	/*
	 * This method creates the RobotImpl instance by taking name as input
	 * and returns reference of that instance.
	 * 
	 * @Param name   Robot name
	 * @Return RobotIntf   RobotIntf reference
	 */
	public RobotIntf create(String name){
		
		RobotIntf roboDetail = new RobotImpl();
		roboDetail.setName(name);
		roboDetail.setRoboPlatform(new RobotPlatform());
		
		return roboDetail;
			
	}

}

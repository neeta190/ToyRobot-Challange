package com.toy.robot.store;

import java.util.List;

import com.toy.robot.main.RobotIntf;

/**
 * This is a interface that act as the repository for the robots.
 *
 */
public interface RobotStore {
	
	/*
	 * This is a abstract method that returns the list of created robots from repository.
	 * 
	 * @Return List   list of robot names
	 */
	public List<String> listRobots();
	
	/*
	 * This is a abstract method that adds the created robots to the repository.
	 * 
	 * @Param robot   RobotIntf Object
	 */
	public void addRobots(RobotIntf robot);
	
	/*
	 * This is a abstract method that checks whether the robot exist in the repository.
	 * 
	 * @Param name   Robot Name
	 * @Return robot   RobotIntf Object
	 */
	public RobotIntf checkForRobotExistanceInStore(String name);
	
	
}

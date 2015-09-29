package com.toy.robot.store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.toy.robot.main.RobotIntf;

public class RobotStoreImpl implements RobotStore{

	private static List<RobotIntf> robotList = new CopyOnWriteArrayList<RobotIntf>();
	
	/*
	 * This is an implementation method that returns the list of created robots from repository.
	 * 
	 * @Return List   list of robot names
	 */
	public List<String> listRobots() {
		
		List<String> resultantList = new ArrayList<String> ();
		
		for (RobotIntf roboDetail : robotList)
		{
			resultantList.add(roboDetail.getName());
		}
		
		return resultantList;
		
	}

	/*
	 * This is an implementation method that adds the created robots to the repository.
	 * 
	 * @Param robot   RobotIntf Object
	 */
	public void addRobots(RobotIntf robot) {
		
		robotList.add(robot);
		
	}

	/*
	 * This is an implementation method that checks whether the robot exist in the repository.
	 * 
	 * @Param name   Robot Name
	 * @Return robot   RobotIntf Object
	 */
	public RobotIntf checkForRobotExistanceInStore(String name) {
		
		RobotIntf existingRobot = null;
		for (RobotIntf roboDetail : robotList)
		{
			if(roboDetail.getName().equalsIgnoreCase(name))
			{
				existingRobot = roboDetail;
				break;
			}
		}
		return existingRobot;
		
	}

}

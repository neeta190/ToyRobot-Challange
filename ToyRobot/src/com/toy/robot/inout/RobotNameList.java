package com.toy.robot.inout;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is created to send the list of robots as Output for the robot service.
 *
 */
public class RobotNameList {
	
	List<String> robotNameList = new ArrayList<String> ();

	/*
	 * This is a getter method for list of robot names.
	 * 
	 * @Return List   list containing the robot names as String
	 */
	public List<String> getRobotNameList() {
		return robotNameList;
	}

	/*
	 * This is a setter method for list of robot names.
	 * 
	 * @Param List   list containing the robot names as String
	 */
	public void setRobotNameList(List<String> robotNameList) {
		this.robotNameList = robotNameList;
	}
}

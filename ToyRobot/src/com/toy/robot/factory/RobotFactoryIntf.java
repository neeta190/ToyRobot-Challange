package com.toy.robot.factory;

import com.toy.robot.main.RobotIntf;

/**
 * This is a robot factory interface that provides the 
 * reference to the instance of robot class on demand.
 *
 */
public interface RobotFactoryIntf {
	
	/*
	 * This is a abstract method that return reference to RobotImpl instance.
	 * 
	 * @Param name   Robot name
	 * @Return RobotIntf   RobotIntf reference
	 */
	public RobotIntf create(String name);
	
}

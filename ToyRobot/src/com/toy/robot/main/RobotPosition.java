package com.toy.robot.main;

import com.toy.robot.enums.Angle;

/**
 * This is an interface that depicts the position and direction of robot on Platform.
 *
 */
public interface RobotPosition {
	
	/*
	 * This is a abstract getter method for direction.
	 * 
	 * @Return Angle   Angle Object representing direction
	 */
	public Angle getAngle();
	
	/*
	 * This is a abstract setter method for direction.
	 * 
	 * @Param angle   Angle Object representing direction
	 */
	public void setAngle(Angle angle);
	
	/*
	 * This is a abstract getter method for X position of robot on platform.
	 * 
	 * @Return int   integer value representing X position
	 */
	public int getX_pos();
	
	/*
	 * This is a abstract setter method for X position of robot on platform.
	 * 
	 * @Param x_pos   integer value representing X position
	 */
	public void setX_pos(int x_pos);
	
	/*
	 * This is a abstract getter method for Y position of robot on platform.
	 * 
	 * @Return int   integer value representing Y position
	 */
	public int getY_pos();
	
	/*
	 * This is a abstract setter method for Y position of robot on platform.
	 * 
	 * @Param y_pos   integer value representing Y position
	 */
	public void setY_pos(int y_pos);
	
	/*
	 * This is a abstract method for calculating the XY position of robot on platform.
	 * 
	 */
	public void calculateXYPosition();
	
	/*
	 * This is a abstract method for calculating the direction of robot on issue of left command.
	 * 
	 */
	public void calculateLeftAngle();
	
	/*
	 * This is a abstract method for calculating the direction of robot on issue of right command.
	 * 
	 */
	public void calculateRightAngle();
	
		
}

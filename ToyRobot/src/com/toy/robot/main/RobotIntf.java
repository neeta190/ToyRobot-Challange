package com.toy.robot.main;


/**
 * This is an interface that depicts the behavior or functioning of robot.
 *
 */
public interface RobotIntf {
	
	/*
	 * This is a abstract getter method for robot name.
	 * 
	 * @Return String   String representing robot name
	 */
	public String getName();
	
	/*
	 * This is a abstract setter method for robot name.
	 * 
	 * @Param name   String representing robot name
	 */
	public void setName(String name);
	
	/*
	 * This is a abstract getter method for robot position.
	 * 
	 * @Return RobotPosition   RobotPosition Object representing reference to robot position
	 */
	public RobotPosition getRoboPosition();
	
	/*
	 * This is a abstract setter method for robot position.
	 * 
	 * @Param roboPosition   RobotPosition Object representing reference to robot position
	 */
	public void setRoboPosition(RobotPosition roboPosition);
	
	/*
	 * This is a abstract getter method for robot platform dimensions.
	 * 
	 * @Return RobotPlatform   RobotPlatform Object representing the robot platform dimensions 
	 */
	public RobotPlatform getRoboPlatform();
	
	/*
	 * This is a abstract setter method for robot platform dimensions.
	 * 
	 * @Param roboPlatform   RobotPlatform Object representing the robot platform dimensions 
	 */
	public void setRoboPlatform(RobotPlatform roboPlatform);
	
	/*
	 * This is an abstract method for placing the robot on platform at a 
	 * particular position and direction.
	 * 
	 * @Param angle   Angle Object representing direction
	 * @Param x_pos   integer value representing X position
	 * @Param y_pos   integer value representing Y position
	 * @Return boolean   boolean returning true or false
	 */	
	public boolean place(String angle, int x_pos, int y_pos);
	
	/*
	 * This is an abstract method for moving the robot one step forward 
	 * on issue of move command.
	 * 
	 * @Return boolean   boolean returning true or false
	 */	
	public boolean move();
	
	/*
	 * This is an abstract method for changing the direction of robot 
	 * towards left with respect to current direction on issue of left command.
	 * 
	 * @Return boolean   boolean returning true or false
	 */	
	public boolean left();
	
	/*
	 * This is an abstract method for changing the direction of robot towards 
	 * right with respect to current direction on issue of right command.
	 * 
	 * @Return boolean   boolean returning true or false
	 */	
	public boolean right();

}

package com.toy.robot.inout;

/**
 * This class is created to receive Input and send Output for the robot service.
 *
 */
public class InputOutput {
	
	private String angle;
	private int x_pos;
	private int y_pos;
	
	
	/*
	 * This is a getter method for direction.
	 * 
	 * @Return String   String representing direction
	 */
	public String getAngle() {
		return angle;
	}
	
	/*
	 * This is a setter method for direction.
	 * 
	 * @Param String   String representing direction
	 */
	public void setAngle(String angle) {
		this.angle = angle;
	}
	
	/*
	 * This is a getter method for X position of robot on platform.
	 * 
	 * @Return int   integer value representing X position
	 */
	public int getX_pos() {
		return x_pos;
	}
	
	/*
	 * This is a setter method for X position of robot on platform.
	 * 
	 * @Param int   integer value representing X position
	 */
	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}
	
	/*
	 * This is a getter method for Y position of robot on platform.
	 * 
	 * @Return int   integer value representing Y position
	 */
	public int getY_pos() {
		return y_pos;
	}
	
	/*
	 * This is a setter method for Y position of robot on platform.
	 * 
	 * @Param int   integer value representing Y position
	 */
	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	
	/*
	 * The method is used to convert the object to string value
	 * 
	 */
	public String toString(){

		String result = "Angle : " + getAngle() + "\n" +
		"X_Pos : " + getX_pos() + "\n" +
		"Y_Pos : " + getY_pos();
		
		return result;
	}
}

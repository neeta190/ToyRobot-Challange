package com.toy.robot.main;

/**
 * This is an class that determine the dimensions of Platform on which the robot is placed.
 * Assumption is that the platform is of dimensions 5 unit X 5 unit
 */
public class RobotPlatform {
	
	private int x_pos_max = 5;
	private int x_pos_min = 0;
	private int y_pos_max = 5;
	private int y_pos_min = 0;
	
	/*
	 * This is a getter method for the maximum X position that robot can reach  on platform.
	 * 
	 * @Return int   integer value representing maximum X position
	 */
	public int getX_pos_max() {
		return x_pos_max;
	}
	
	/*
	 * This is a setter method for the maximum X position that robot can reach  on platform.
	 * 
	 * @Param x_pos_max   integer value representing maximum X position
	 */
	public void setX_pos_max(int x_pos_max) {
		this.x_pos_max = x_pos_max;
	}
	
	/*
	 * This is a getter method for the minimum X position that robot can reach  on platform.
	 * 
	 * @Return int   integer value representing minimum X position
	 */
	public int getX_pos_min() {
		return x_pos_min;
	}
	
	/*
	 * This is a setter method for the minimum X position that robot can reach  on platform.
	 * 
	 * @Return x_pos_min   integer value representing minimum X position
	 */
	public void setX_pos_min(int x_pos_min) {
		this.x_pos_min = x_pos_min;
	}
	
	/*
	 * This is a getter method for the maximum Y position that robot can reach  on platform.
	 * 
	 * @Return int   integer value representing maximum Y position
	 */
	public int getY_pos_max() {
		return y_pos_max;
	}
	
	/*
	 * This is a setter method for the maximum Y position that robot can reach  on platform.
	 * 
	 * @Return y_pos_max   integer value representing maximum Y position
	 */
	public void setY_pos_max(int y_pos_max) {
		this.y_pos_max = y_pos_max;
	}
	
	/*
	 * This is a getter method for the minimum Y position that robot can reach  on platform.
	 * 
	 * @Return int   integer value representing minimum Y position
	 */
	public int getY_pos_min() {
		return y_pos_min;
	}
	
	/*
	 * This is a getter method for the minimum Y position that robot can reach  on platform.
	 * 
	 * @Return y_pos_min   integer value representing minimum Y position
	 */
	public void setY_pos_min(int y_pos_min) {
		this.y_pos_min = y_pos_min;
	}
	
	/*
	 * This method is used for checking whether the robot is positioned with in the valid 
	 * platform dimensions.
	 * 
	 * @Param x_pos   integer value representing X position
	 * @Param y_pos   integer value representing Y position
	 * @Return boolean   value returning true/false as result
	 */
	public boolean checkForTablePlatformPosition(int x_pos, int y_pos)
	{
		boolean result = false;
		if (x_pos >= this.x_pos_min && x_pos < this.x_pos_max && y_pos >= this.y_pos_min && y_pos < this.y_pos_max)
			result = true;
		return result;
	}
	
	/*
	 * The method is used to convert the object to string value
	 * 
	 */
	public String toString(){

		String result = "X_Po_Max : " + getX_pos_max() + "\n" +
		"X_Pos_Min : " + getX_pos_min() + "\n" +
		"Y_Pos_Max : " + getY_pos_max()+ "\n" +
		"Y_Pos_Min : " + getY_pos_min();
		
		return result;
	}

}

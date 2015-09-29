package com.toy.robot.main;

import java.util.EnumMap;

import com.toy.robot.enums.Angle;

/**
 * This class is used for determining the position and direction of robot on Platform.
 *
 */
public class RobotPositionImpl implements RobotPosition{
	
	private Angle angle;
	private int x_pos;
	private int y_pos;
	
	private static EnumMap<Angle, Angle> leftMap = new EnumMap<>(Angle.class);
	private static EnumMap<Angle, Angle> rightMap = new EnumMap<>(Angle.class);
	
	/* The leftMap and rightMap are the enum maps and are used for storing the direction in which the robot 
	 * should move corresponding to the current direction once left and right commands are issued respectively.
	 */
	static{
		
		leftMap.put(Angle.NORTH, Angle.WEST);
		leftMap.put(Angle.SOUTH, Angle.EAST);
		leftMap.put(Angle.EAST, Angle.NORTH);
		leftMap.put(Angle.WEST, Angle.SOUTH);
		
		
		rightMap.put(Angle.NORTH, Angle.EAST);
		rightMap.put(Angle.SOUTH, Angle.WEST);
		rightMap.put(Angle.EAST, Angle.SOUTH);
		rightMap.put(Angle.WEST, Angle.NORTH);
	}
	
	/*
	 * This is a getter method for direction.
	 * 
	 * @Return Angle   Angle Object representing direction
	 */
	public Angle getAngle() {
		return angle;
	}
	
	/*
	 * This is a setter method for direction.
	 * 
	 * @Param angle   Angle Object representing direction
	 */
	public void setAngle(Angle angle) {
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
	 * @Param x_pos   integer value representing X position
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
	 * @Param y_pos   integer value representing Y position
	 */
	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	
	/*
	 * This method is used for calculating the XY position of robot on platform on issue of move command
	 * 
	 */
	public void calculateXYPosition()
	{
		Angle angle = Angle.valueOf(this.angle.name().toUpperCase());
		switch(angle){
		 case NORTH :
			 this.y_pos = this.y_pos + 1;
			 break;
		 case SOUTH :
			 this.y_pos = this.y_pos - 1;
			 break;
		 case EAST :
			this.x_pos = this.x_pos + 1;
			break;
		case WEST:
			this.x_pos = this.x_pos - 1;
			break;
		}
	}
	
	/*
	 * This method is used for calculating the direction of robot on issue of left command.
	 * 
	 */
	public void calculateLeftAngle()
	{
		this.angle = leftMap.get(Angle.valueOf(this.angle.name().toUpperCase()));
	}
	
	/*
	 * This method is used for calculating the direction of robot on issue of right command.
	 * 
	 */
	public void calculateRightAngle()
	{
		this.angle = rightMap.get(Angle.valueOf(this.angle.name().toUpperCase()));
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

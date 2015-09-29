package com.toy.robot.main;

import com.toy.robot.enums.Angle;

/**
 * This is an implementation class that depicts the behavior or functioning of robot.
 *
 */
public class RobotImpl implements RobotIntf{
	
	private String name;
	private RobotPosition roboPosition;
	private RobotPlatform roboPlatform;
	
	/*
	 * This is a getter method for robot name.
	 * 
	 * @Return String   String representing robot name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * This is a setter method for robot name.
	 * 
	 * @Param name   String representing robot name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * This is a getter method for robot position.
	 * 
	 * @Return RobotPosition   RobotPosition Object representing reference to robot position
	 */
	public RobotPosition getRoboPosition() {
		return roboPosition;
	}
	
	/*
	 * This is a setter method for robot position.
	 * 
	 * @Param roboPosition   RobotPosition Object representing reference to robot position
	 */
	public void setRoboPosition(RobotPosition roboPosition) {
		this.roboPosition = roboPosition;
	}
	
	/*
	 * This is a getter method for robot platform dimensions.
	 * 
	 * @Return RobotPlatform   RobotPlatform Object representing the robot platform dimensions 
	 */
	public RobotPlatform getRoboPlatform() {
		return roboPlatform;
	}
	
	/*
	 * This is a setter method for robot platform dimensions.
	 * 
	 * @Param roboPlatform   RobotPlatform Object representing the robot platform dimensions 
	 */
	public void setRoboPlatform(RobotPlatform roboPlatform) {
		this.roboPlatform = roboPlatform;
	}
	
	/*
	 * This method is used for placing the robot on platform at a particular 
	 * position and direction.
	 * 
	 * @Param angle   Angle Object representing direction
	 * @Param x_pos   integer value representing X position
	 * @Param y_pos   integer value representing Y position
	 * @Return boolean   boolean returning true or false
	 */	
   public boolean place(String angle, int x_pos, int y_pos) {
		
		if(!this.roboPlatform.checkForTablePlatformPosition(x_pos, y_pos))
		{
			return false;
		}
		else {
			if (this.getRoboPosition() == null)
				this.setRoboPosition(new RobotPositionImpl());
			this.getRoboPosition().setAngle(Angle.valueOf(angle.toUpperCase()));
			this.getRoboPosition().setX_pos(x_pos);
			this.getRoboPosition().setY_pos(y_pos);
		}
		
		return true;
	}
   
   /*
	* This method is used for moving the robot one step forward on issue of 
	* move command.
	* 
	* @Return boolean   boolean returning true or false
	*/	
   public boolean move(){
	   
		if(this.roboPosition == null){
			return false;
		}else {
			RobotPosition newPosition = new RobotPositionImpl ();
			newPosition.setAngle(this.roboPosition.getAngle());
			newPosition.setX_pos(this.roboPosition.getX_pos());
			newPosition.setY_pos(this.roboPosition.getY_pos());
			newPosition.calculateXYPosition();
			if(!this.roboPlatform.checkForTablePlatformPosition(newPosition.getX_pos(), newPosition.getY_pos()))
			{
				return false;
			}
			else
				this.setRoboPosition(newPosition);
		}
		return true;
	}
   
   /*
	* This method is used for changing the direction of robot towards left with 
	* respect to current direction on issue of left command.
	* 
	* @Return boolean   boolean returning true or false
	*/	
   public boolean left()
   {
	   if(this.roboPosition == null)
			return false;
	   else 
		   this.roboPosition.calculateLeftAngle();
	   
	   return true;
   }
   
   /*
	* This method is used for changing the direction of robot towards right with 
	* respect to current direction on issue of right command.
	* 
	* @Return boolean   boolean returning true or false
	*/	
   public boolean right()
   {
	   if(this.roboPosition == null)
			return false;
	   else 
		   this.roboPosition.calculateRightAngle();
	   
	   return true;
   }
	
   /*
	* The method is used to convert the object to string value
	* 
	*/
	public String toString(){

		String result = "Name : " + getName() + "\n" +
		"RobotPosition : " + getRoboPosition() + "\n" +
		"RobotPlatform : " + getRoboPlatform();
		
		return result;
	}

}
